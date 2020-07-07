package com.jay.mvvmhiltkotlin.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.jay.mvvmhiltkotlin.R
import com.jay.mvvmhiltkotlin.adapter.PersonAdapter
import com.jay.mvvmhiltkotlin.api.ErrorHandling
import com.jay.mvvmhiltkotlin.api.ErrorHandling.Companion.ERROR_CHECK_NETWORK_CONNECTION
import com.jay.mvvmhiltkotlin.api.ErrorHandling.Companion.GENERIC_ERROR
import com.jay.mvvmhiltkotlin.api.Resource
import com.jay.mvvmhiltkotlin.api.Resource.Status
import com.jay.mvvmhiltkotlin.base.BaseActivity
import com.jay.mvvmhiltkotlin.databinding.ActivityMainBinding
import com.jay.mvvmhiltkotlin.model.user.PersonDetail
import com.jay.mvvmhiltkotlin.viewmodel.PersonDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    // Get a reference to the ViewModel scoped to this Fragment
    private val viewModel by viewModels<PersonDetailViewModel>()

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.person_list)
        initDataBinding()
        attachObserver()
    }

    /**
     * Method to attach observer
     */
    private fun attachObserver() {
        viewModel.peopleLiveData.observe(this, Observer<Resource<List<PersonDetail>>> { resource ->
            when (resource.status) {
                Status.LOADING -> {
                    showLoadingDialog(true)
                }
                Status.SUCCESS -> {
                    showLoadingDialog(false)
                }
                Status.ERROR -> {
                    showLoadingDialog(false)
                    if (ErrorHandling.isNetworkError(resource.message ?: "")) {
                        Toast.makeText(this, ERROR_CHECK_NETWORK_CONNECTION, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, GENERIC_ERROR, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    /**
     * Method to initialise DataBinding
     */
    private fun initDataBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.lifecycleOwner = this
        activityMainBinding.viewModel = viewModel
        activityMainBinding.adapter = PersonAdapter(mutableListOf(),
                callBack = {
                    viewModel.updatePerson(it)
                })
        //post the page
        viewModel.postPeoplePage(1)
    }

    /**
     * @param show true to show progress dialog, false otherwise
     */
    private fun showLoadingDialog(show: Boolean) {
        if (show) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE
    }

}