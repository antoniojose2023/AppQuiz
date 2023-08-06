package br.com.antoniojoseuchoa.appquiz.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import br.com.antoniojoseuchoa.appquiz.R
import br.com.antoniojoseuchoa.appquiz.databinding.FragmentSegundaQuestaoBinding
import br.com.antoniojoseuchoa.appquiz.databinding.FragmentTerceiraQuestaoBinding
import com.tapadoo.alerter.Alerter


class TerceiraQuestaoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTerceiraQuestaoBinding.inflate(layoutInflater, container, false)

        //recuperar valor nome que do fragment anterior
        var nome = ""
        nome = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getString("nome", "vázio") as String
        }else{
            arguments?.getString("nome") as String
        }

        binding.tvNomeUsuario.text = "Olá, ${nome}"

        //verificando radio buttons
        binding.btProximo.setOnClickListener {
            if(binding.rgQuestoes1.isChecked){
                exibirAlerta("Erro", R.color.red, R.drawable.ic_erro)
            }

            if(binding.rgQuestoes2.isChecked){
                exibirAlerta("Erro", R.color.red, R.drawable.ic_erro)
            }

            if(binding.rgQuestoes3.isChecked){
                exibirAlerta("Correto", R.color.green, R.drawable.ic_correto)
                //Thread.sleep(3000)
                exibirAlertDialogFinalizacao(nome)
            }

            if(binding.rgQuestoes4.isChecked){
                exibirAlerta("Erro", R.color.red, R.drawable.ic_erro)
            }
        }

        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    fun exibirAlerta(mensage: String, color: Int, icon: Int){
        Alerter.create(requireActivity())
            .setTitle("Confira sua resposta")
            .setText(mensage)
            .setBackgroundColorRes(color)
            .setIcon(icon)
            .show()
      }


     fun exibirAlertDialogFinalizacao(nome: String){
          AlertDialog.Builder(requireContext())
              .setMessage("Parabéns, $nome você finalizou o quiz com sucesso.")
              .setPositiveButton("Começar novamente"){ param1, param2 ->
                      requireActivity().supportFragmentManager
                          .beginTransaction()
                          .replace(R.id.fragment_container, HomeFragment())
                          .commit()
              }
              .show()
     }



}