//complete

package server.bin.main.languify.app.classes.experts

import Text
import server.bin.main.languify.app.classes.enums.Language

interface Expert {
    fun guessLanguage(text: Text): Language
}