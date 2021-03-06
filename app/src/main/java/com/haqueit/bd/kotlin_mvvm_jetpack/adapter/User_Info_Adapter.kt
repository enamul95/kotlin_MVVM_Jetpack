package com.haqueit.bd.kotlin_mvvm_jetpack.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.haqueit.bd.kotlin_mvvm_jetpack.model.User_info_Data
import  com.haqueit.bd.kotlin_mvvm_jetpack.R
import com.haqueit.bd.kotlin_mvvm_jetpack.util.getProgressDrawble
import com.haqueit.bd.kotlin_mvvm_jetpack.util.loadImage
import com.haqueit.bd.kotlin_mvvm_jetpack.view.User_List_FragmentDirections
import kotlinx.android.synthetic.main.row_user_list.view.*

class User_Info_Adapter (var user_list:ArrayList<User_info_Data>): RecyclerView.Adapter<User_Info_Adapter.DepositViewHolder>() {


    private lateinit var activity: Activity

    fun updatelList(
        newLogList: List<User_info_Data>,
        activity: Activity
    )
    {

        user_list.clear();
        user_list.addAll(newLogList)
        this.activity = activity
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): User_Info_Adapter.DepositViewHolder {
        var inflater: LayoutInflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.row_user_list,parent,false);
        return DepositViewHolder(view);
    }

    override fun getItemCount() = user_list.size



    override fun onBindViewHolder(
        holder: User_Info_Adapter.DepositViewHolder,
        position: Int
    ) {

        holder.view.tv_mobile_number.text = user_list[position].MOBILE_NO
        holder.view.name.text = user_list[position].FULL_NAME
        holder.view.tv_email.text = user_list[position].EMAIL
        holder.view.tv_address.text = user_list[position].ADDRESS


        holder.view.img_profile.loadImage(user_list[position].image_url, getProgressDrawble(holder.view.img_profile.context))

        holder.view.setOnClickListener {
           Navigation.findNavController(it).navigate(User_List_FragmentDirections.actionListFragmentToListFragmentDetails())
        }

        // image_url
        //   img_profile.loadImage(it.image_url, getProgressDrawble(img_profile.context))

    }

    class DepositViewHolder(var view: View): RecyclerView.ViewHolder(view)



}