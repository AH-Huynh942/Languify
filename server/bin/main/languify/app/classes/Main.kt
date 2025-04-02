import server.bin.main.languify.app.classes.experts.ExpertManager

fun main(args: Array<String>) {
    //obtain from front end
    val str = "hello world"
    val obtainer = TextObtainer()
    val text : Text = obtainer.stringToTextObject(str)
    val expertManager : ExpertManager = ExpertManager()
    //determine language
    val Language = expertManager.determineLanguage(text)
    //Databases.LanguageFactsLayout.obtainFacts(language)
    //send to front end

    val string: String = "hello world"

    val arr: ByteArray = string.toByteArray(Charsets.UTF_16)

    print(arr[1])



    /*
    var languageSyntaxDB = LanguageSyntaxDatabase()
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.ARMENIAN, server.bin.main.languify.app.classes.enums.Script.UNIQUE, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.GEORGIAN, server.bin.main.languify.app.classes.enums.Script.UNIQUE, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.SINHALA, server.bin.main.languify.app.classes.enums.Script.UNIQUE, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.HEBREW, server.bin.main.languify.app.classes.enums.Script.UNIQUE, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.INUKTITUT, server.bin.main.languify.app.classes.enums.Script.UNIQUE, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.CHEROKEE, server.bin.main.languify.app.classes.enums.Script.UNIQUE, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.TAMIL, server.bin.main.languify.app.classes.enums.Script.UNIQUE, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.KHMER, server.bin.main.languify.app.classes.enums.Script.UNIQUE, 0,0)

    //this may be the wrong database i still have to figure out the best way to organize
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.ENGLISH, server.bin.main.languify.app.classes.enums.Script.LATIN, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.SPANISH, server.bin.main.languify.app.classes.enums.Script.LATIN, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.FRENCH, server.bin.main.languify.app.classes.enums.Script.LATIN, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.PORTUGUESE, server.bin.main.languify.app.classes.enums.Script.LATIN, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.GERMAN, server.bin.main.languify.app.classes.enums.Script.LATIN, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.VIETNAMESE, server.bin.main.languify.app.classes.enums.Script.LATIN, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.TURKISH, server.bin.main.languify.app.classes.enums.Script.LATIN, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.POLISH, server.bin.main.languify.app.classes.enums.Script.LATIN, 0,0)

    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.ARABIC, server.bin.main.languify.app.classes.enums.Script.ARABIC, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.FARSI, server.bin.main.languify.app.classes.enums.Script.ARABIC, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.DARI, server.bin.main.languify.app.classes.enums.Script.ARABIC, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.URDU, server.bin.main.languify.app.classes.enums.Script.ARABIC, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.UYGHUR, server.bin.main.languify.app.classes.enums.Script.ARABIC, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.KURDISH, server.bin.main.languify.app.classes.enums.Script.ARABIC, 0,0)
    languageSyntaxDB.addLanguage(server.bin.main.languify.app.classes.enums.Language.PASHTO, server.bin.main.languify.app.classes.enums.Script.ARABIC, 0,0)
*/
}