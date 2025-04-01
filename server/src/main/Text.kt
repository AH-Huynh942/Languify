package server.src.main

class Text {
    private val textString: String
    private var utf: ByteArray

    constructor(textString: String) {
        this.textString = textString
        utf = textString.toByteArray(Charsets.UTF_16)
    }

    fun checkIfInUnicodeRange(range: ByteArray): Boolean{
        var isInRange : Boolean = false
        for (i in utf){
            if (i>=range[0] && i<=range[1]){
                isInRange = true
            }
        }
        return isInRange
    }
}