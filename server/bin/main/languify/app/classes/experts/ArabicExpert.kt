//gurman code

package server.bin.main.languify.app.classes.experts

import Text
import server.bin.main.languify.app.classes.enums.Language

class ArabicExpert: Expert {
    override fun guessLanguage(text: Text): Language {
        return Language.NONE
    }
}