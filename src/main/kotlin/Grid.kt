class Grid(val cells: Array<Array<Cell>>) {
    constructor(cells: String) : this(toRows(cells))
    private companion object {
        fun toRows(cells: String) = cells
            .split("\n")
            .map(::toCell)
            .toTypedArray()

        private fun toCell(cell: String)= cell
                .chunked(1)
                .map(::Cell)
                .toTypedArray()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Grid
        if (!cells.contentDeepEquals(other.cells)) return false
        return true
    }

    override fun hashCode(): Int = cells.contentDeepHashCode()
}