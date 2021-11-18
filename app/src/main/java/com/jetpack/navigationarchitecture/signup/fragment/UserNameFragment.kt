package com.jetpack.navigationarchitecture.signup.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.jetpack.navigationarchitecture.R
import com.jetpack.navigationarchitecture.databinding.FragmentUserNameBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserNameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserNameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var binding: FragmentUserNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_name, container, false)
        binding.button.setOnClickListener {
            if (!TextUtils.isEmpty(binding.edUserName.text.toString())){
                val bundle:Bundle = bundleOf("user_name" to binding.edUserName.text.toString())
                it.findNavController().navigate(R.id.action_userNameFragment_to_emailFragment,bundle)
            }else Toast.makeText(activity,"Please enter name", Toast.LENGTH_LONG).show()

        }
        return binding.root
    }


}