package com.app.tictactoe.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.app.tictactoe.R
import com.app.tictactoe.presenter.MainActivityPresenter
import com.app.tictactoe.presenter.MainActivityPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    lateinit var presenter: MainActivityPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenterImpl(this)
        reset.setOnClickListener { presenter.reset() }
    }

    /**
     * This onclick method retrieves
     * row index and column index
     * @param view
     */
    fun onCellClicked(view: View) {
        presenter.onCellClicked(
            view.tag.toString().substring(0, 1).toInt(),
            view.tag.toString().substring(1, 2).toInt()
        )
    }

    /**
     * This method sets the player name on selected cell
     * @param row
     * @param col
     * @param player
     */
    override fun setCellText(row: Int, col: Int, player: String) {
        val cell: Button = grid_tictactoe.findViewWithTag("" + row + col)
        cell.text = player
    }

    /**
     * This method sets the winner label
     * @param player is the player(X or O) who won
     */
    override fun showWinnerLabel(player: String) {
        info_text.text = resources.getString(R.string.winner, player)
        info_text.visibility = View.VISIBLE
        presenter.updateCells()
    }

    /**
     * This method sets the label for draw
     */
    override fun setLabelDrawn() {
        info_text.text = resources.getString(R.string.level_drawn)
        info_text.visibility = View.VISIBLE
        presenter.updateCells()
    }

    /**
     * This method hides the winner label
     * Called after reset
     */
    override fun hideInfoLabel() {
        info_text.visibility = View.GONE
    }

    /**
     * This method disables cells
     * Called after game is finishes
     * @param row
     * @param col
     */
    override fun disableCells(row: Int, col: Int) {
        val cell: Button = grid_tictactoe.findViewWithTag("" + row + col)
        cell.isEnabled = false
    }

    /**
     * This method enables cells
     * Called after game is finished
     * @param row
     * @param col
     */
    override fun enableCells(row: Int, col: Int) {
        val cell: Button = grid_tictactoe.findViewWithTag("" + row + col)
        cell.isEnabled = true
    }

}
