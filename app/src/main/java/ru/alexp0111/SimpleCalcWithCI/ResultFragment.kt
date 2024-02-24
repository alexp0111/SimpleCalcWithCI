package ru.alexp0111.SimpleCalcWithCI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.alexp0111.SimpleCalcWithCI.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var result: Double? = null

    private var _binding: FragmentResultBinding? = null
    private val binding: FragmentResultBinding
        get() = checkNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            result = getDouble(RESULT_VALUE_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(layoutInflater)
        binding.txtResult.text = result.toString()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}