package languify

class Text{
    private val textString: String
    private var utf: ByteArray

    constructor(textString: String) {
        this.textString = textString
        utf = textString.toByteArray(Charsets.UTF_16)
    }

    //the range should only be of length 2 else there is an error
    //may add error
    //this is used to check if the at least one of the characters in a text is in the range, indicating it belongs to that specific language
    fun checkIfInUnicodeRange(range: ByteArray): Boolean{
        var isInRange : Boolean = false
        for (i in utf){
            if (i>=range[0] && i<=range[1]){
                isInRange = true
            }
        }
        return isInRange
    }

    fun getString():String{
        return textString
    }
}
