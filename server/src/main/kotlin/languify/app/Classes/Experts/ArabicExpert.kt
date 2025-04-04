package languify

import java.io.File
import java.util.Properties

import com.detectlanguage.DetectLanguage

class ArabicExpert: Expert {
    override fun guessLanguage(text: Text): Language {

        try {
            val apiKey = loadApiKey()
            DetectLanguage.apiKey = apiKey
        } catch (e: Exception) {
            return Language.NONE
        }
        val result = DetectLanguage.simpleDetect(text.getString())
        val lang = Language.toLanguage(result)

        try {
            val resultNotNull: Language = lang!!
            return checkLanguage(resultNotNull)
        } catch (npe: NullPointerException) {
            return Language.NONE
        }
    }

    private fun checkLanguage(language: Language): Language {
        if (language.equals(Language.ARABIC)) {
            return Language.ARABIC
        } else if (language.equals(Language.PERSIAN)) {
            return Language.PERSIAN
        } else if (language.equals(Language.URDU)) {
            return Language.URDU
        } else if (language.equals(Language.KURDISH)) {
            return Language.KURDISH
        } else if (language.equals(Language.PASHTO)) {
            return Language.PASHTO
        } else {
            return Language.NONE
        }
    }

    private fun loadApiKey(): String? {
        val properties = Properties()
        val file = File("local.properties")
        if (file.exists()) {
            properties.load(file.inputStream())
            return properties.getProperty("API_KEY")
        }
        return null
    }
}

