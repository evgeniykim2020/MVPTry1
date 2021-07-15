package com.evgeniykim.mvptry1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.evgeniykim.mvptry1.contract.Contract
import com.evgeniykim.mvptry1.databinding.ActivityMainBinding
import com.evgeniykim.mvptry1.model.Model
import com.evgeniykim.mvptry1.presenter.Presenter

class MainActivity : AppCompatActivity(), Contract.View {

    private var textView: TextView? = null
    private var button: Button? = null
    private var progressBar: ProgressBar? = null
//    private lateinit var binding: ActivityMainBinding

    var presenter: Contract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
        setContentView(R.layout.activity_main)

//        binding.textView.text = textView.toString()
//        binding.button.setOnClickListener { button!!.setOnClickListener { View.OnClickListener { presenter!!.onButtonClick() } } }
//        progressBar.findViewById(R.id.progressBar)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)

        presenter = Presenter(this, Model())

        this.button!!.setOnClickListener(View.OnClickListener { presenter!!.onButtonClick() })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        textView!!.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
        textView!!.visibility = View.VISIBLE
    }

    override fun setString(string: String?) {
        textView!!.text = string
    }
}