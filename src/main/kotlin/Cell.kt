class Cell(val alive: Boolean) {
    constructor(string: String) : this(string == ALIVE)
    val dead = !alive
    companion object {
        fun isCell(s: String) =
            s == DEAD || s == ALIVE
        private const val DEAD = "."
        private const val ALIVE = "*"
    }

    infix fun evolveWith(neighbours: Array<Cell>) = Cell(shouldBeAlive(neighbours))

    private fun shouldBeAlive(neighbours: Array<Cell>) =
        if (dead) shouldComeAlive(neighbours)
        else shouldStayAlive(neighbours)

    private fun shouldComeAlive(neighbours: Array<Cell>) = numberOfAliveNeighbours(neighbours) == 3
    private fun shouldStayAlive(neighbours: Array<Cell>) = numberOfAliveNeighbours(neighbours) in 2..3

    private fun numberOfAliveNeighbours(neighbours: Array<Cell>) = neighbours
        .filter(Cell::alive)
        .size

    fun intValue() = if(alive) 1 else 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Cell
        if (alive != other.alive) return false

        return true
    }

    override fun toString(): String = if(alive) ALIVE else DEAD

    override fun hashCode(): Int {
        return alive.hashCode()
    }

}