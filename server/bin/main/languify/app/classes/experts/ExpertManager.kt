//complete

package server.bin.main.languify.app.classes.experts

import server.bin.main.languify.app.classes.enums.Language
import Text

class ExpertManager
{
    private var uniqueResult: Language = Language.NONE
    private var latinResult: Language = Language.NONE
    private var arabicResult: Language = Language.NONE

    private val uniqueExpert: Expert = UniqueExpert()
    private val latinExpert: Expert = LatinExpert()
    private val arabicExpert: Expert = ArabicExpert()

    fun determineLanguage(text: Text) : Language {
        var finalResult : Language = Language.NONE
        askExperts(text)
        if (uniqueResult!= Language.NONE){
            finalResult = uniqueResult
        }else if (latinResult!= Language.NONE){
            finalResult = latinResult
        }else if (arabicResult!= Language.NONE){
            finalResult = arabicResult
        }else{
            finalResult = Language.NONE
        }
        resetExpertResults()
        return finalResult
    }

    private fun askExperts(text: Text){
        uniqueResult = uniqueExpert.guessLanguage(text)
        latinResult = latinExpert.guessLanguage(text)
        arabicResult = arabicExpert.guessLanguage(text)
    }

    private fun resetExpertResults(){
        uniqueResult = Language.NONE
        latinResult = Language.NONE
        arabicResult = Language.NONE
    }

}