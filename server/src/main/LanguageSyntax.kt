package server.src.main

//fix namings to make this all more clear because right now its all over the place


data class LanguageSyntax(
    val id: Int,
    val name: Language,
    //make these enum maybe both above and bottom
    //unique, latin, arabic
    val category: Script,
    val unicodeRange: ByteArray
    //val unicodeRangeLower: Int
    //val unicodeRangeUpper: Int
    //maybe more data
) {
    //check what this does and if it works
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LanguageSyntax

        if (id != other.id) return false
        if (name != other.name) return false
        if (category != other.category) return false
        if (!unicodeRange.contentEquals(other.unicodeRange)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + category.hashCode()
        result = 31 * result + unicodeRange.contentHashCode()
        return result
    }
}

class LanguageSyntaxDatabase
{
    private val languages = mutableListOf<LanguageSyntax>()
    private var nextID = 1

    //figure out how to make some of this stuff mutable
    fun addLanguage(newName: Language, newCategory: Script, newUnicodeRangeUpper: Byte, newUnicodeRangeLower: Byte): LanguageSyntax
    {
        val newLanguage = LanguageSyntax(
            id = nextID++,
            name = newName,
            category = newCategory,
            unicodeRange = byteArrayOf(newUnicodeRangeUpper, newUnicodeRangeLower)
        )
        languages.add(newLanguage)
        return newLanguage
    }

    private fun findLanguageSyntax(language : Language): LanguageSyntax? {
        return languages.find {it.name == language}
    }


    private fun getLanguageUnicode(language : Language): ByteArray {
        val item : LanguageSyntax ? = findLanguageSyntax(language)
        return item?.unicodeRange ?: byteArrayOf(0,0)
    }

    fun compareTextToLanguage(text : Text, language : Language): Boolean{
        val codeRange = getLanguageUnicode(language)
        return text.checkIfInUnicodeRange(codeRange)
    }
}
