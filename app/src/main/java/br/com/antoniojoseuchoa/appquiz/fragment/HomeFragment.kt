package br.com.antoniojoseuchoa.appquiz.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.antoniojoseuchoa.appquiz.R
import br.com.antoniojoseuchoa.appquiz.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btEnviar.setOnClickListener {
            val nome = binding.tvInputEdittNome.text.toString()
            if(nome.isNotEmpty()){
                binding.tvInputNome.error = null
                val primeiraQuestaoFragment = PrimeiraUQuestaoFragment()
                val budle = Bundle()
                budle.putString("nome", nome)
                primeiraQuestaoFragment.arguments = budle

               requireActivity().supportFragmentManager
                   .beginTransaction()
                   .replace(R.id.fragment_container, primeiraQuestaoFragment)
                   .commit()

            }else{
                binding.tvInputNome.error = "Campo vázio"
            }
        }

        return binding.root
    }


}