class Cell(val alive: Boolean) {
    constructor(string: String) : this(string == ALIVE)
    val dead = !alive
    companion object {
        fun isCell(s: String) =
            s == DEAD || s == ALIVE
        const val DEAD = "."
        const val ALIVE = "*"
    }

    infix fun evolveWith(neighbours: Array<Cell>) = Cell(shouldBeAlive(neighbours))

    private fun shouldBeAlive(neighbours: Array<Cell>) =
        if (dead) shouldComeAlive(neighbours)
        else shouldStayAlive(neighbours)

    private fun shouldComeAlive(neighbours: Array<Cell>) = neighbours.aliveNeighbours() == 3
    private fun shouldStayAlive(neighbours: Array<Cell>) = neighbours.aliveNeighbours() in 2..3

    private fun Array<Cell>.aliveNeighbours() = filter(Cell::alive).size

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Cell
        if (alive != other.alive) return false
        return true
    }

    override fun toString(): String = if(alive) "  O" else "  $DEAD"
    override fun hashCode() = alive.hashCode()
}