package languify.app.classes.databases

import languify.Language

data class LanguageFacts(
    val id: Int,
    val language: String,
    //phrases to know
    val hello: String,
    val goodbye: String,
    val howAreYou: String,
    val numberOfSpeakers: Int,
    //list
    val officialLanguageCountries: List<String>,
)


/*
    Determines the layout of the language facts
 */
class LanguageFactsLayout {

//    fun LanguageFactsLayout(){}

    fun retrieveFacts(language: Language) : LanguageFacts {
        return retrieveLanguageFacts(language.toString())
    }

}
