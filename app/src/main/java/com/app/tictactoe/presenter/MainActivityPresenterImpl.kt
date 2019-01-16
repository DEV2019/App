package com.app.tictactoe.presenter

import com.app.tictactoe.model.Board

class MainActivityPresenterImpl(val view: MainActivityPresenter.View) : MainActivityPresenter {

    private val board by lazy { Board() }

    /**
     * Sets the text on the cell in grid touched
     * The value of the text can be X or O
     * If the player has won, sets the winning label
     * @param row
     * @param col
     */
    override fun onCellClicked(row: Int, col: Int) {
        val player = board.setPlayer(row, col)

        if (player != null) {
            view.setCellText(row, col, player.toString())
        }

        if (board.winningPlayer != null) {
            view.showWinnerLabel(player.toString())
        } else if (board.cellsClicked == 9) {
            view.setLabelDrawn()
        }
    }

    /**
     * Clear the board when the user taps on reset button
     */
    override fun reset() {
        board.clear()
        updateGridCells(true)
        view.hideInfoLabel()
    }

    /**
     * Disable the cells as son as the game is over
     */
    override fun updateCells() {
        updateGridCells(false)
    }

    private fun updateGridCells(isReset: Boolean) {
        for (row in 0..2) {
            for (column in 0..2) {
                if (isReset) {
                    view.setCellText(row, column, "")
                    view.enableCells(row, column)
                } else {
                    view.disableCells(row, column)
                }
            }
        }
    }
}
