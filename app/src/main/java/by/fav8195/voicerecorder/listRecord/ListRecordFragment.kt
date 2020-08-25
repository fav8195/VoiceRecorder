package by.fav8195.voicerecorder.listRecord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import by.fav8195.voicerecorder.R
import by.fav8195.voicerecorder.database.RecordDatabase
import by.fav8195.voicerecorder.databinding.FragmentListRecordBinding


class ListRecordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentListRecordBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list_record, container, false)

        val application = requireNotNull(this.activity).application

        // Get a reference to the binding object and inflate the fragment views.
        val dataSource = RecordDatabase.getInstance(application).recordDatabaseDao
        val viewModelFactory = ListRecordViewModelFactory(dataSource)

        // Get a reference to the ViewModel associated with this fragment.
        val listRecordViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(ListRecordViewModel::class.java)

        // To use the View Model with data binding, you have to explicitly
        // give the binding object a reference to it.
        binding.listRecordViewModel = listRecordViewModel

        val adapter =
            ListRecordAdapter()
        binding.recyclerView.adapter = adapter

        listRecordViewModel.records.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        // Specify the current activity as the lifecycle owner of the binding.
        // This is necessary so that the binding can observe LiveData updates.
        binding.lifecycleOwner = this


        return binding.root
    }

}