package server.src.main

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
