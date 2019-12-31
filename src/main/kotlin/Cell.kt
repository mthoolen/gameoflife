data class Cell(val alive: Boolean) {
    constructor(string: String) : this(string == "*")
    val dead = !alive
    override fun toString(): String {
        return if(alive) "*" else "."
    }

}