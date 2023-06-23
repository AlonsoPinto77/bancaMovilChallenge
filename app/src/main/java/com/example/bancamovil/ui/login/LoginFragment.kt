package com.example.bancamovil.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.bancamovil.data.common.PREF_TOKEN
import com.bancamovil.data.common.PREF_USER_ID
import com.bancamovil.data.utils.PrefUtils
import com.bancamovil.domain.common.Resource
import com.bancamovil.domain.interactors.login.LoginRequest
import com.example.bancamovil.R
import com.example.bancamovil.databinding.FragmentLoginBinding
import org.koin.android.ext.android.inject

class LoginFragment: Fragment() {
    private val loginViewModel: LoginViewModel by inject()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeLoginState()

        //nav_view.visibility = View.GONE

        binding.btnLogin.setOnClickListener {
            if(!binding.edDni.text.toString().isNullOrEmpty() || !binding.edPassword.text.toString().isNullOrEmpty()){
                login(binding.edDni.text.toString().toInt(), binding.edPassword.text.toString())
                NavHostFragment.findNavController(this).navigate(R.id.navigation_product)
            }
        }
    }

    private fun login(dni: Int, password: String){
        loginViewModel.login(LoginRequest(dni, password))
    }

    private fun observeLoginState(){
        loginViewModel.viewState.observe(this) { state ->
            when (state) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    if (state.data!!.equals("ok"))
                        PrefUtils.setIntPreference(
                            requireContext(),
                            PREF_USER_ID,
                            binding.edDni.text.toString().toInt()
                        )
                    else
                        Toast.makeText(
                            requireContext(),
                            "Usuario y/o contraseña incorrectos",
                            Toast.LENGTH_SHORT
                        ).show()
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), state.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
                else -> Unit
            }
        }
    }

}