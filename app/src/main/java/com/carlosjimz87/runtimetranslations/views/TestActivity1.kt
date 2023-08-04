package com.carlosjimz87.runtimetranslations.views

import android.content.Intent
import android.os.Bundle
import com.carlosjimz87.runtimetranslations.R
import com.carlosjimz87.runtimetranslations.base.BaseActivity
import com.carlosjimz87.runtimetranslations.databinding.TestActivity1Binding

class TestActivity1 : BaseActivity() {

    private val binding by lazy { TestActivity1Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.activity1_title)

        binding.button.setOnClickListener {
            startActivity(Intent(this, TestActivity2::class.java))
        }
    }
}
