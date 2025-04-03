package languify

enum class Language(val apiCode: String) {
    //unique languages
    KOREAN("ko"),
    ARMENIAN("hy"),
    GEORGIAN("ka"),
    SINHALA("si"),
    HEBREW("iw"),
    INUKTITUT("iu"),
    CHEROKEE("chr"),
    TAMIL("ta"),
    KHMER("km"),

    //latin languages
    ENGLISH("en"),
    SPANISH("es"),
    FRENCH("fr"),
    PORTUGUESE("pt"),
    GERMAN("de"),
    VIETNAMESE("vi"),
    TURKISH("tr"),
    POLISH("pl"),

    //arabic languages
    ARABIC("ar"),
    PERSIAN("fa"),
    URDU("ur"),
    KURDISH("ku"),
    PASHTO("ps"),

    // this will be passed when the expert has no idea
    NONE("NA");

    companion object {
        fun toLanguage(name: String): Language? {
            return entries.find { it.apiCode.equals(name) }
        }
    }


}
