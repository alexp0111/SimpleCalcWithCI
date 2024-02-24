package ru.alexp0111.SimpleCalcWithCI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.alexp0111.SimpleCalcWithCI.databinding.FragmentEnterValuesBinding
import ru.alexp0111.SimpleCalcWithCI.logic.MyCalc

const val RESULT_VALUE_KEY = "result"

class EnterValuesFragment : Fragment() {

    private var _binding: FragmentEnterValuesBinding? = null
    private val binding: FragmentEnterValuesBinding
        get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterValuesBinding.inflate(inflater)

        setupClickListner()

        return binding.root
    }

    private fun setupClickListner() {
        binding.apply {
            btnFindSum.setOnClickListener {
                findSumOfEditTexts()
            }
        }
    }

    private fun findSumOfEditTexts() {
        val firstValue = validateNumber(binding.etFirstValue.text.toString())
        val secondValue = validateNumber(binding.etSecondValue.text.toString())

        if (firstValue == null || secondValue == null) {
            Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            return
        }

        val result = MyCalc().findSum(firstValue, secondValue)
        val fragment = ResultFragment().apply {
            arguments = Bundle().apply {
                putDouble(RESULT_VALUE_KEY, result)
            }
        }

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment, "result")
            .addToBackStack("result")
            .commit()
    }

    private fun validateNumber(incomingValue: String): Double? {
        val value = incomingValue.trim()
        if (value.isEmpty()) return null

        return value.toDoubleOrNull()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}