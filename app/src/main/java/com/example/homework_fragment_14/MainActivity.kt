package com.example.homework_fragment_14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class MainActivity : AppCompatActivity(), FragmentListener {

    private var containerOne: FrameLayout? = null
    private var btnAdd : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupListeners()
    }

    private fun setupListeners() {
        btnAdd?.setOnClickListener {
            setupFragment()
        }
    }
    private fun setupViews() {
        containerOne =findViewById(R.id.containerOne)
        btnAdd = findViewById(R.id.btnAdd)
    }
    private fun setupFragment(){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.containerOne,FirstFragment())
            .commit()
    }

    override fun changeFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerOne,SecondFragment())
            .commit()

    }

    override fun removeFragment() {
        supportFragmentManager
            .beginTransaction()
            .remove(SecondFragment())
            .commit()
    }


}