package com.example.calculator_v20.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.Exception
import com.example.calculator_v20.databinding.FragmentSecondBinding
import net.objecthunter.exp4j.ExpressionBuilder


class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root



    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn0.setOnClickListener{ setTextFields("0") }

        binding.btn1.setOnClickListener{ setTextFields("1") }

        binding.btn2.setOnClickListener{ setTextFields("2") }

        binding.btn3.setOnClickListener{ setTextFields("3") }

        binding.btn4.setOnClickListener{ setTextFields("4") }

        binding.btn5.setOnClickListener{ setTextFields("5") }

        binding.btn6.setOnClickListener{ setTextFields("6") }

        binding.btn7.setOnClickListener{ setTextFields("7") }

        binding.btn8.setOnClickListener{ setTextFields("8") }

        binding.btn9.setOnClickListener{ setTextFields("9") }

        binding.btnDot.setOnClickListener{ setTextFields(".") }

        binding.btnMinus.setOnClickListener{ setTextFields("-") }

        binding.btnPlus.setOnClickListener{ setTextFields("+") }

        binding.btnMultiply.setOnClickListener{ setTextFields("*") }

        binding.btnDivision.setOnClickListener{ setTextFields("/") }

        binding.btnAC.setOnClickListener {
            binding.calculation.text = ""
            binding.result.text = ""
        }

        binding.btnBack.setOnClickListener {
            val str = binding.calculation.text.toString()
            if (str.isNotEmpty())
                binding.calculation.text = str.substring(0, str.length - 1)

            binding.result.text = ""
        }

        binding.btnEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(binding.calculation.text.toString()).build()
                val result = expression.evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    binding.result.text = longRes.toString()
                else
                    binding.result.text = result.toString()


            } catch (e:Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }

    fun setTextFields (str: String){
        if (binding.result.text != ""){
            binding.calculation.text = binding.result.text
            binding.result.text = ""
        }
        binding.calculation.append(str)
    }
}



