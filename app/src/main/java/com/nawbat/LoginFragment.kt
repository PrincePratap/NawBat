package com.nawbat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nawbat.MVVM.APIs.Login.LoginRequest.LoginRequest
import com.nawbat.MVVM.ViewModel.AuthViewModel
import com.nawbat.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {



    private lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var authViewModel: AuthViewModel


    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)

        sharedPreferences = requireActivity().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)


        authViewModel.getLoginResponse(LoginRequest("jh1","asdjhjhasda","A","testt1yuouthfdsfTY4@gmail.com","Abc@123"))

        responseLoginFun()

        return binding.root
    }


    private fun responseLoginFun(){
        authViewModel.loginResponseLiveData.observe(viewLifecycleOwner){it
            Toast.makeText(context,it.message, Toast.LENGTH_LONG).show()
            setDataInSharedPreferences(it.data.auth_token)
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

        }
    }
    private fun setDataInSharedPreferences(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString("token", token)
        editor.apply()
    }

}