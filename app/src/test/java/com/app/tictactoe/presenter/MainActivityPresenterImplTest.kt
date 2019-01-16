package com.app.tictactoe.presenter

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.powermock.api.easymock.PowerMock

class MainActivityPresenterImplTest {

    lateinit var presenter: MainActivityPresenterImpl
    lateinit var view: MainActivityPresenter.View

    @Before
    fun setUp() {
        view = PowerMock.createMock(MainActivityPresenter.View::class.java)
        presenter = MainActivityPresenterImpl(view)
    }

    @After
    fun tearDown() {
        PowerMock.verifyAll()
        PowerMock.resetAll()
    }

    @Test
    fun onCellClicked_default() {
        val row = 2
        val col = 2

        view.setCellText(2, 2, "X")

        PowerMock.replayAll()

        presenter.onCellClicked(row, col)
    }
}
