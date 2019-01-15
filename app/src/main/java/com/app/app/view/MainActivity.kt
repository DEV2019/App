package com.app.app.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.app.R
import com.app.app.presenter.MainActivityPresenter
import com.app.app.presenter.MainActivityPresenterImpl

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    lateinit var presenter: MainActivityPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenterImpl(this)

    }

    override fun setCellText(row: Int, col: Int, player: String) {
    }
}
