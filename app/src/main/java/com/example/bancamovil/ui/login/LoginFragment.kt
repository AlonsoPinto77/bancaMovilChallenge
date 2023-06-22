package com.example.bancamovil.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bancamovil.data.common.PREF_TOKEN
import com.bancamovil.data.common.PREF_USER_ID
import com.bancamovil.data.utils.PrefUtils
import com.bancamovil.domain.common.Resource
import com.bancamovil.domain.interactors.login.LoginRequest
import com.example.bancamovil.R
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.row_product_cardview.*

class LoginFragment: Fragment() {
    private val loginViewModel: LoginViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeLoginState()

        btnLogin.setOnClickListener {
            if(!edDni.text.toString().isNullOrEmpty() || !edPassword.text.toString().isNullOrEmpty())
                login(edDni.text.toString().toInt(), edPassword.text.toString())
        }
    }

    private fun login(dni: Int, password: String){
        loginViewModel.login(LoginRequest(dni, password))
    }

    private fun observeLoginState(){
        loginViewModel.viewState.observe(this,{ state->
            when(state){
                is Resource.Loading ->{

                }
                is Resource.Success ->{
                    PrefUtils.setIntPreference(requireContext(), PREF_USER_ID, edDni.text.toString().toInt())
                }
                is Resource.Error ->{
                    Toast.makeText(requireContext(), state.message.toString(), Toast.LENGTH_SHORT).show()
                }
                else -> Unit
            }
        })
    }

}