package languify.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Display
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.pdftron.pdf.PDFDoc
import com.pdftron.pdf.PDFNet
import com.pdftron.pdf.TextExtractor
import com.pdftron.pdf.config.PDFNetConfig
import kotlinx.coroutines.launch
import languify.app.classes.BackendRequester
import languify.app.classes.databases.LanguageFacts
import java.io.InputStream

class InputPDFPage: ComponentActivity() {
    private lateinit var pdfAccessManager: PdfAccessManager
    lateinit var inputStream : InputStream
    lateinit var storedExtractedText : String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        try {
            PDFNet.initialize(this, 0, "")
        } catch (e: Exception) {
            Log.e("PDFTron", "Error initializing PDFNet: ${e.message}")
            Toast.makeText(this, "Failed to initialize PDF library", Toast.LENGTH_LONG).show()
            finish() // Close the activity if initialization fails
            return
        }
        setContentView(R.layout.page_pdf_input)
        val inputText =findViewById<EditText>(R.id.mtPDFTextInputBox)
        val buttonIdentify = findViewById<Button>(R.id.btExtract)
        val buttonSelectPdf = findViewById<Button>(R.id.btSelectPdf)
        // TODO GET BACKEND FEEDBACK -- Actual IDENTIFY BUTTON
        val buttonIdentifyReal = findViewById<Button>(R.id.btText)
        pdfAccessManager = PdfAccessManager(this)

        buttonSelectPdf.setOnClickListener {
            selectPdfFromStorage()
        }



            buttonIdentify.setOnClickListener {
                val inputStream = this.inputStream
                try {
                    val doc = PDFDoc(inputStream)
                    val page = doc.getPage(1)

                    val txt = TextExtractor()
                    txt.begin(page!!)  // Read the page.

                    // Create a StringBuilder to build the extracted text
                    val extractedText = StringBuilder()

                    var word: TextExtractor.Word
                    var line: TextExtractor.Line = txt.firstLine
                    while (line.isValid) {
                        word = line.firstWord
                        while (word.isValid) {
                            // Append each word to our text
                            extractedText.append(word.string)
                            extractedText.append(" ")  // Add a space between words
                            word = word.nextWord
                        }
                        extractedText.append("\n")  // Add a newline at the end of each line
                        line = line.nextLine
                    }
                    storedExtractedText = extractedText.toString()
                    Log.i("TESTINGPDF", extractedText.toString())
                    inputText.setText(extractedText.toString())

                } catch (e: Exception) {
                    // Handle any exceptions
                    e.printStackTrace()
                    Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }

            buttonIdentifyReal.setOnClickListener {
                Log.i(
                    "PDFANSWER",
                    "***************************PRESSING THE IDENTIFY BUTTON***************************************"
                )
                Log.i("PDFANSWER", storedExtractedText)
                buttonIdentifyReal.setOnClickListener {
                    Log.i(
                        "DEBUGGING BACKEND",
                        "***************************PRESSING THE IDENTIFY BUTTON***************************************"
                    )
                    Log.i("DEBUGGING BACKEND", storedExtractedText)

//            var result : LanguageFacts = sendBackendInput(storedExtractedText)

            lifecycleScope.launch {
                val result = BackendRequester().detectLanguage(storedExtractedText)
                // Use the detected language
                Log.i("DEBUGGING BACKEND", "INPUT")
                Log.i("DEBUGGING BACKEND", storedExtractedText)

                Log.i("DEBUGGING BACKEND", "GOT BACK FEEDBACK")
                Log.i("DEBUGGING BACKEND", "---------------------------------------------")
                Log.i("DEBUGGING BACKEND", result.languageName)
                val intent = Intent(this@InputPDFPage, DisplayPage::class.java)
                intent.putExtra("ID", result.id)
                intent.putExtra("LANGUAGE_CODE", result.language.name) // Assuming Language is an enum
                intent.putExtra("LANGUAGE_NAME", result.languageName)
                intent.putExtra("HELLO", result.hello)
                intent.putExtra("GOODBYE", result.goodbye)
                intent.putExtra("HOW_ARE_YOU", result.howAreYou)
                intent.putExtra("NUMBER_OF_SPEAKERS", result.numberOfSpeakers)
                intent.putExtra("OFFICIAL_COUNTRIES", result.officialLanguageCountries.toTypedArray())
                startActivity(intent)
            }

        }
    }



        }
    fun selectPdfFromStorage() {
        pdfAccessManager.openPdfFromStorage { inputStream, error ->
            if (error != null) {
                Log.e("PDFAccess", "Error: ${error.message}")
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_LONG).show()
            } else if (inputStream != null) {
                this.inputStream = inputStream
            }
        }
    }
    }
