package com.haqueit.bd.kotlin_mvvm_jetpack.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.haqueit.bd.kotlin_mvvm_jetpack.R
import com.haqueit.bd.kotlin_mvvm_jetpack.adapter.User_Info_Adapter
import com.haqueit.bd.kotlin_mvvm_jetpack.util.Custom_alert
import com.haqueit.bd.kotlin_mvvm_jetpack.viewmodel.Users_Info_ViewModel

/**
 * A simple [Fragment] subclass.
 */
class User_List_Fragment : Fragment() {

    private lateinit var userViewModel: Users_Info_ViewModel
    private val userlistAdapter = User_Info_Adapter(arrayListOf())

    private lateinit var recycler_view: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_list, container, false)


        recycler_view = root.findViewById(R.id.recycler_view)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel =
            ViewModelProviders.of(this).get(Users_Info_ViewModel::class.java)

        recycler_view.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = userlistAdapter
        }
        if(Custom_alert.isOnline(activity)==false){
            Custom_alert.showInternetConnectionMessage(activity);
        }else{

            activity?.let { it1 -> userViewModel.getuser_info_list(it1) };

        }

        observeViewModel()
    }

    fun  observeViewModel(){

        userViewModel.user_info_list.observe(this,  androidx.lifecycle.Observer {
            activity?.let { it1 -> userlistAdapter.updatelList(it, it1) }
        })


    }



}
