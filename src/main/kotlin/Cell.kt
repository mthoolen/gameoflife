data class Cell(val alive: Boolean) {
    constructor(string: String) : this(string == "*")

    val dead = !alive
}