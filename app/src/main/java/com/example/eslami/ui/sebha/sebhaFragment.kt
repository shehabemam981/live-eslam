package com.example.eslami.ui.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eslami.R
import com.example.eslami.databinding.FragmentSebhaBinding

class sebhaFragment : Fragment() {
    lateinit var binding: FragmentSebhaBinding
    var counter: Int = 0
    var counterText: Int = 0
    lateinit var azkarList: MutableList<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.counter.text = counter.toString()
        binding.text3.text = azkarList[counterText]
        moveSebha()
    }

    private fun moveSebha() {
        binding.body.setOnClickListener {
            binding.body.rotation += (360/33).toFloat()
            if (counter < 33) {
                counter++

            } else {
                counter = 0
                if (counterText < azkarList.size - 1) {
                    ++counterText
                }else{
                    counterText = 0
                }
                    binding.text3.text = azkarList[counterText]

            }
            binding.counter.text = counter.toString()
        }
    }
}
