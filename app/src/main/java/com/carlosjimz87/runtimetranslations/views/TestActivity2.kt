package com.carlosjimz87.runtimetranslations.views

import android.content.Intent
import android.os.Bundle
import com.carlosjimz87.runtimetranslations.R
import com.carlosjimz87.runtimetranslations.base.BaseActivity
import com.carlosjimz87.runtimetranslations.databinding.TestActivity1Binding
import com.carlosjimz87.runtimetranslations.databinding.TestActivity2Binding

class TestActivity2 : BaseActivity() {

    private val binding by lazy { TestActivity2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity_2)

        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.activity2_title)

        binding.button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
