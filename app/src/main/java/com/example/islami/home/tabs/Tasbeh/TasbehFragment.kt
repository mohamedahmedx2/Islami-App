package com.example.islami.home.tabs.Tasbeh

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentSebhaBinding

class TasbehFragment : Fragment() {

    lateinit var viewBinding: FragmentSebhaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSebhaBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    private var currentStep = 0
    private val totalSteps = 30
    var cumulativeAngle = 0f
    var count: Int = 0
    val defaultZekr: String = "اضغط علي السبحة لبداية التسبيح"
    val myMutableList = mutableListOf("سبحان الله", "الحمد لله", "الله اكبر")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //  Binding.main.setBackgroundResource(R.drawable.background_sebha)
        viewBinding.defaultTv.text = defaultZekr
        viewBinding.framsebha.setOnClickListener {
            viewBinding.defaultTv.text = null

            val angleIncrement = (360 / totalSteps).toFloat()
            cumulativeAngle += angleIncrement

            val frameAnimator = ObjectAnimator.ofFloat(
                viewBinding.framsebha,
                "rotation",
                viewBinding.framsebha.rotation,
                cumulativeAngle
            )
            frameAnimator.duration = 300
            frameAnimator.interpolator = LinearInterpolator()
            frameAnimator.start()

            currentStep = (currentStep + 1) % totalSteps
            count++
            when {
                count in 1..30 -> {
                    viewBinding.tvZekr.text = myMutableList[0]
                    viewBinding.tvCountZekr.text = count.toString()
                }

                count in 31..60 -> {
                    viewBinding.tvZekr.text = myMutableList[1]
                    viewBinding.tvCountZekr.text = (count - 30).toString()
                }

                count in 61..90 -> {
                    viewBinding.tvZekr.text = myMutableList[2]
                    viewBinding.tvCountZekr.text = (count - 60).toString()

                }

                count >= 90 -> {
                    count = 0
                    viewBinding.tvZekr.text = null
                    viewBinding.tvCountZekr.text = null
                    viewBinding.defaultTv.text = defaultZekr
                    show("انتهيت من جميع الأذكار")
                }

                else -> {
                    show("حدث خطأ غير متوقع!")
                }
            }


        }
    }

    fun show(mes: String) {

        Toast.makeText(requireContext(), mes, Toast.LENGTH_LONG).show()
    }


}
