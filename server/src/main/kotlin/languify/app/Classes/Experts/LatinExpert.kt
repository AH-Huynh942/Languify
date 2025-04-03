package languify

import java.io.File
import java.util.Properties

import com.detectlanguage.DetectLanguage
// English, French, Spanish, French, portugese, german, turkish, polish, vietnamese
class LatinExpert: Expert {
    override fun guessLanguage(text: Text): Language {
        try{
            val apiKey = loadApiKey()
            DetectLanguage.apiKey = apiKey
        }
        catch(e: Exception){
            return Language.NONE
        }
        val result = DetectLanguage.simpleDetect(text.getString())
        val lang = Language.toLanguage(result)

        try{
            val resultNotNull: Language = lang!!
        }
        catch (npe: NullPointerException){
            return Language.NONE
        }
        val resultNotNull: Language = lang!!


        if (resultNotNull.equals(Language.ENGLISH)){
            return Language.ENGLISH
        }
        else if (resultNotNull.equals(Language.SPANISH)){
            return Language.SPANISH
        }
        else if (resultNotNull.equals(Language.FRENCH)){
            return Language.FRENCH
        }
        else if (resultNotNull.equals(Language.PORTUGUESE)){
            return Language.PORTUGUESE
        }
        else if (resultNotNull.equals(Language.GERMAN)){
            return Language.GERMAN
        }
        else if (resultNotNull.equals(Language.VIETNAMESE)){
            return Language.VIETNAMESE
        }
        else if (resultNotNull.equals(Language.TURKISH)){
            return Language.TURKISH
        }
        else if (resultNotNull.equals(Language.POLISH)){
            return Language.POLISH
        }
        else{
            return Language.NONE

        }
    }

    fun loadApiKey(): String? {
        val properties = Properties()
        val file = File("local.properties")
        if (file.exists()) {
            properties.load(file.inputStream())
            return properties.getProperty("API_KEY")
        }
        return null
    }
}
