package com.example.birthdayapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.birthdayapp.databinding.ItemUserListBinding
import com.example.domain.BirthDayUser

class UserAdapter(private val listener: (BirthDayUser) -> Unit) :
    ListAdapter<BirthDayUser, UserAdapter.UserViewHolder>(object :
        DiffUtil.ItemCallback<BirthDayUser>() {

        override fun areItemsTheSame(oldItem: BirthDayUser, newItem: BirthDayUser): Boolean =
            oldItem.initials == newItem.initials

        override fun areContentsTheSame(oldItem: BirthDayUser, newItem: BirthDayUser): Boolean =
            oldItem == newItem

    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            ItemUserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val birthdayUser = getItem(position)
        holder.bind(birthdayUser)
        holder.itemView.setOnClickListener {
            listener(birthdayUser)
        }
    }

    class UserViewHolder(private val binding: ItemUserListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(birthDayUser: BirthDayUser) {
            binding.userAvatar.text = birthDayUser.initials
            binding.userName.text = birthDayUser.name
            binding.userBirthdayDate.text = birthDayUser.birthdayDate
        }
    }
}