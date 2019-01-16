package com.app.tictactoe.model

class Board {

    private val cells = Array<Array<Cell?>>(3) { arrayOfNulls(3) }
    private var currentPlayer: Player? = null
    private var state: State? = null
    var winningPlayer: Player? = null

    init {
        start()
    }

    /**
     * Setup a new game
     */
    private fun start() {
        clearCells()
        currentPlayer = Player.X
        winningPlayer = null
        state = State.IN_PROGRESS
    }

    /**
     * Assigns each cell with a new instance
     */
    private fun clearCells() {
        for (i in 0..2) {
            for (j in 0..2) {
                cells[i][j] = Cell()
            }
        }
    }

    /**
     * Set the current player's move.
     *
     * @param row 0..2
     * @param col 0..2
     * @return the player that moved or null if we did not move anything.
     */
    fun setPlayer(row: Int, col: Int): Player? {
        var player: Player? = null

        if (isValid(row, col)) {
            cells[row][col]?.value = currentPlayer
            player = currentPlayer

            if (isPlayerWinning(currentPlayer, row, col)) {
                state = State.FINISHED
                winningPlayer = currentPlayer

            } else {
                // change the current player and continue
                changePlayer()
            }

        }

        return player
    }

    private fun isValid(row: Int, col: Int) =
        state != State.FINISHED && isCorrectRowOrColumn(row, col) && cells[row][col]?.value == null

    private fun changePlayer() {
        currentPlayer = if (currentPlayer === Player.X) Player.O else Player.X
    }

    private fun isCorrectRowOrColumn(row: Int, col: Int) = row in 0..2 && col in 0..2

    private enum class State { IN_PROGRESS, FINISHED }

    /**
     * Algorithm for winning scenarios:
     * 3 in a row
     * 3 in a column
     * 3 in diagonal
     * 3 in opposite diagonal
     * @param player
     * @param currentRow
     * @param currentCol
     * @return true if the player won else false
     */
    private fun isPlayerWinning(player: Player?, currentRow: Int, currentCol: Int): Boolean {

        return ((cells[currentRow][0]?.value === player        // 3-in-the-row
                && cells[currentRow][1]?.value === player
                && cells[currentRow][2]?.value === player)
                || (cells[0][currentCol]?.value === player     // 3-in-the-column
                && cells[1][currentCol]?.value === player
                && cells[2][currentCol]?.value === player)
                || (currentRow == currentCol                   // 3-in-the-diagonal
                && cells[0][0]?.value === player
                && cells[1][1]?.value === player
                && cells[2][2]?.value === player)
                || (currentRow + currentCol == 2               // 3-in-the-opposite-diagonal
                && cells[0][2]?.value === player
                && cells[1][1]?.value === player
                && cells[2][0]?.value === player))
    }

    fun clear() {
        start()
    }
}
