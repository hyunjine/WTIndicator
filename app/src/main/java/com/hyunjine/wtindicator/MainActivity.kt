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
            setInitCurrentSelectedIndicator(img3, R.drawable.shape_indicator_selected)
        }

    private fun setInitCurrentSelectedIndicator(view: ImageView, drawableId: Int) {
        setImageViewDrawable(view, drawableId)
        currentSelectedIndicator = view
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
        }

    private fun changeIndicator(currentView: ImageView) {
        if (currentView == currentSelectedIndicator) return
        setImageViewDrawable(currentSelectedIndicator, R.drawable.shape_indicator)
        currentSelectedIndicator = currentView
        setImageViewDrawable(currentView, R.drawable.shape_indicator_selected)
    }

    private fun setImageViewDrawable(view: ImageView, drawableId: Int) =
        view.setImageResource(drawableId)
}