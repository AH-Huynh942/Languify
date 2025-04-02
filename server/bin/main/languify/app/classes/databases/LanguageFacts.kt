package server.bin.main.languify.app.classes.databases

data class LanguageFacts(
    val id: Int,
    val language: String,
    //phrases to know
    val hello: String,
    val goodbye: String,
    val howAreYou: String,
    val numberOfSpeakers: Int,
    //list
    val officialLanguageCountries: String,
    val widelySpokenInCountries: String
)




//navigator for data class
//andy make this helper to fill the database and make it easy for end
//fill database with languages and facts
class LanguageFactsDatabase{

}





