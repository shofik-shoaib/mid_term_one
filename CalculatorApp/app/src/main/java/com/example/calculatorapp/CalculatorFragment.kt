package com.example.calculatorapp

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class CalculatorFragment : Fragment() {

    private lateinit var etNum1: EditText
    private lateinit var etNum2: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etNum1 = view.findViewById(R.id.etNum1)
        etNum2 = view.findViewById(R.id.etNum2)
        tvResult = view.findViewById(R.id.tvResult)
        btnAdd = view.findViewById(R.id.btnAdd)
        btnSubtract = view.findViewById(R.id.btnSubtract)
        btnMultiply = view.findViewById(R.id.btnMultiply)
        btnDivide = view.findViewById(R.id.btnDivide)

        btnAdd.setOnClickListener { calculate("add") }
        btnSubtract.setOnClickListener { calculate("subtract") }
        btnMultiply.setOnClickListener { calculate("multiply") }
        btnDivide.setOnClickListener { calculate("divide") }
    }

    private fun calculate(operation: String) {
        val num1Str = etNum1.text.toString()
        val num2Str = etNum2.text.toString()

        if (TextUtils.isEmpty(num1Str) || TextUtils.isEmpty(num2Str)) {
            tvResult.text = "Please enter valid numbers"
            return
        }

        val num1 = num1Str.toDouble()
        val num2 = num2Str.toDouble()
        var result: Double? = null

        when (operation) {
            "add" -> result = num1 + num2
            "subtract" -> result = num1 - num2
            "multiply" -> result = num1 * num2
            "divide" -> result = if (num2 != 0.0) num1 / num2 else null
        }

        if (result == null) {
            tvResult.text = "Cannot divide by zero"
        } else {
            tvResult.text = result.toString()
        }
    }

    companion object {
        fun newInstance() = CalculatorFragment()
    }
}
