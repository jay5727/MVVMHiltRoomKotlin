package com.jay.mvvmhiltkotlin.adapter

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jay.mvvmhiltkotlin.R
import com.jay.mvvmhiltkotlin.databinding.ItemPersonBinding
import com.jay.mvvmhiltkotlin.model.user.PersonDetail

/**
 * @param items : List of Persons
 * @param callBack : Higher order function callback
 */
class PersonAdapter(private val items: MutableList<PersonDetail>, val callBack: (PersonDetail) -> Unit) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPersonBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PersonDetail) {
            binding.name = item.name
            binding.picture = item.picture
            binding.location = item.location
            binding.dob = item.dob
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        val selectedPerson = items[position]
        selectedPerson.picture.large?.let {
            Glide.with(holder.itemView.context)
                    .load(it)
                    .placeholder(R.drawable.ic_loading_process)
                    .circleCrop()
                    .into(holder.binding.imgProfilePic)
        }
        holder.binding.accept.setOnClickListener {
            updatePersons(selectedPerson, true, position)
        }
        holder.binding.decline.setOnClickListener {
            updatePersons(selectedPerson, false, position)
        }
        selectedPerson.isAccepted?.let {
            holder.binding.personAction.visibility = VISIBLE
            if (it) {
                holder.binding.personActionAccept.visibility = VISIBLE
                holder.binding.personActionDecline.visibility = GONE
            } else {
                holder.binding.personActionAccept.visibility = GONE
                holder.binding.personActionDecline.visibility = VISIBLE
            }
        } ?: kotlin.run {
            //leverage null condition too...
            holder.binding.personAction.visibility = GONE
        }
    }

    /**
     * @param selectedPerson person to update
     * @param isAccepted true for accepted , false otherwise
     * @param position view holder item position
     */
    private fun updatePersons(selectedPerson: PersonDetail, isAccepted: Boolean, position: Int) {
        selectedPerson.isAccepted = isAccepted
        callBack.invoke(selectedPerson)
        notifyItemChanged(position)
    }

    fun addPeople(personList: List<PersonDetail>) {
        items.clear()
        items.addAll(personList)
        notifyDataSetChanged()
    }
}