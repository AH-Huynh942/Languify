//gurman code this

package server.bin.main.languify.app.classes.experts

import Text
import server.bin.main.languify.app.classes.enums.Language

class LatinExpert: Expert {
    override fun guessLanguage(text: Text): Language {
        return Language.NONE
    }
}