package com.hyunjine.wtindicator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import com.hyunjine.wtindicator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var currentSelectedIndicator: ImageView

    private var indicatorSize: Int = 0
    private var count = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding(layoutInflater)
        setContentView(binding.root)
        setViewComponent()
        setEventListener()
    }

    private fun setBinding(layoutInflater: LayoutInflater) =
        ActivityMainBinding.inflate(layoutInflater).also { binding = it }

    private fun setViewComponent() =
        binding.run {
            setImageViewDrawable(img1, R.drawable.shape_indicator_selected)
            currentSelectedIndicator = img1
        }

    private fun setEventListener() =
        binding.run {
            img1.run {
                setOnClickListener {
                    changeIndicator(this)
                }
            }

            img2.run {
                setOnClickListener {
                    changeIndicator(this)
                }
            }

            img3.run {
                setOnClickListener {
                    changeIndicator(this)
                }
            }

            btn.setOnClickListener {
                setCount()
                when(count) {
                    1 -> changeIndicator(img1)
                    2 -> changeIndicator(img2)
                    3 -> changeIndicator(img3)
                }
            }
        }

    private fun changeIndicator(currentView: ImageView) {
        setImageViewDrawable(currentSelectedIndicator, R.drawable.shape_indicator)
        currentSelectedIndicator = currentView
        setImageViewDrawable(currentView, R.drawable.shape_indicator_selected)
    }

    private fun setImageViewDrawable(view: ImageView, drawableId: Int) =
        view.setImageResource(drawableId)

    private fun setCount() {
        count++
        if (count > indicatorSize) count = 1
    }
}