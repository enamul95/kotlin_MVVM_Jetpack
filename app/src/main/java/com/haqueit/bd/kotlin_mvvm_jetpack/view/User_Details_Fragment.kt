package com.haqueit.bd.kotlin_mvvm_jetpack.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.haqueit.bd.kotlin_mvvm_jetpack.R

/**
 * A simple [Fragment] subclass.
 */
class User_Details_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_details, container, false)
    }


}
