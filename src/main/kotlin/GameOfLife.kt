object GameOfLife {
    fun tick(grid: Grid): Grid {
        val nextCells = grid.cells.map{it.map { Cell(alive = false) }.toTypedArray()}.toTypedArray()
        return Grid(nextCells)
    }
}