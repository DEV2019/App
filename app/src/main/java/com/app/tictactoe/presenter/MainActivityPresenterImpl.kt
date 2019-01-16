package com.app.tictactoe.presenter

import com.app.tictactoe.model.Board

class MainActivityPresenterImpl(val view: MainActivityPresenter.View) : MainActivityPresenter {

    private val board by lazy { Board() }


    override fun onCellClicked(row: Int, col: Int) {
        val player = board.setPlayer(row, col)

        if (player != null) {
            view.setCellText(row, col, player.toString())
        }

        if (board.winningPlayer != null) {
            view.showWinnerLabel(player.toString())
        }
    }

    override fun reset() {
        board.clear()
        updateGridCells(true)
    }

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
