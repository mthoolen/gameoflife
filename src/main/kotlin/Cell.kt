class Cell(val alive: Boolean) {
    constructor(string: String) : this(string == ALIVE)

    val dead = !alive
    companion object {
        fun isCell(s: String) =
            s == DEAD || s == ALIVE
        private const val DEAD = "."
        private const val ALIVE = "*"
    }

    fun intValue() = if(alive) 1 else 0
    override fun toString(): String = if(alive) ALIVE else DEAD

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Cell
        if (alive != other.alive) return false

        return true
    }

    override fun hashCode(): Int {
        return alive.hashCode()
    }

}