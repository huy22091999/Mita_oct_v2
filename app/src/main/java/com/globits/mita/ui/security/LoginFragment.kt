package com.globits.mita.ui.security

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.R
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.data.network.SessionManager
import com.globits.mita.databinding.FragmentLoginBinding
import com.globits.mita.ui.MainActivity
import javax.inject.Inject

class LoginFragment @Inject constructor() : MitaBaseFragment<FragmentLoginBinding>() {

    val viewModel:SecurityViewModel by activityViewModel()
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater,container,false)
    }
    lateinit var username:String
    lateinit var password:String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        SessionManager(requireContext()).saveAuthToken("")
        views.loginSubmit.setOnClickListener {
            loginSubmit()
        }
        super.onViewCreated(view, savedInstanceState)
    }
    private fun loginSubmit()
    {
        username=views.loginField.text.toString().trim()
        password=views.passwordField.text.toString().trim()
        if(username.isNullOrEmpty()) views.loginFieldTil.error=getString(R.string.username_not_empty)
        if(password.isNullOrEmpty()) views.passwordFieldTil.error=getString(R.string.username_not_empty)
        if (!username.isNullOrEmpty()&&!password.isNullOrEmpty())
        {
            viewModel.handle(SecurityViewAction.LogginAction(username,password))
        }
    }

    override fun invalidate(): Unit = withState(viewModel){
        when(it.asyncLogin){
            is Success ->{
                it.asyncLogin.invoke()?.let { token->
                    val sessionManager = context?.let { it1 -> SessionManager(it1.applicationContext) }
                    token.accessToken?.let { it1 -> sessionManager!! .saveAuthToken(it1) }
                    token.refreshToken?.let { it1 -> sessionManager!!.saveAuthTokenRefresh(it1) }
                }
                Toast.makeText(requireContext(),getString(R.string.login_success), Toast.LENGTH_LONG).show()
                startActivity(Intent(requireContext(),MainActivity::class.java))
                activity?.finish()
            }
            is Fail ->{
                views.passwordFieldTil.error=getString(R.string.login_fail)
            }
            else -> {}
        }

    }

}