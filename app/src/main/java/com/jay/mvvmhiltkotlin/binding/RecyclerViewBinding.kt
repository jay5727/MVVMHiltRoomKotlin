package com.jay.mvvmhiltkotlin.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jay.mvvmhiltkotlin.adapter.PersonAdapter
import com.jay.mvvmhiltkotlin.api.Resource
import com.jay.mvvmhiltkotlin.model.user.PersonDetail
import com.jay.mvvmhiltkotlin.pagination.RecyclerViewPaginator
import com.jay.mvvmhiltkotlin.utils.extensions.bindResource
import com.jay.mvvmhiltkotlin.viewmodel.PersonDetailViewModel

/***
 * Created by Jay on 05/07/2020.
 */
@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(view: RecyclerView, adapter: PersonAdapter) {
    view.adapter = adapter
}

@BindingAdapter("adapterPersonList")
fun bindAdapterPersonList(view: RecyclerView, resource: Resource<List<PersonDetail>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? PersonAdapter
        resource?.data?.let {
            adapter?.addPeople(it)
        }
    }
}

@BindingAdapter("personPagination")
fun bindPersonPagination(view: RecyclerView, viewModel: PersonDetailViewModel) {
    RecyclerViewPaginator(
            recyclerView = view,
            isLoading = { viewModel.getPeopleValues()?.status == Resource.Status.LOADING },
            loadMore = { viewModel.postPeoplePage(it) },
            onLast = { false }
    ).run {
        currentPage = 1
    }
}