package com.nawbat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nawbat.Adapters.EventAdapter
import com.nawbat.MVVM.APIs.Event.DataEvent
import com.nawbat.MVVM.ViewModel.MyMainViewModel
import com.nawbat.databinding.FragmentEventBinding
import com.nawbat.databinding.LayoutArticlesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EventFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var myMainViewModel: MyMainViewModel

    private lateinit var binding: FragmentEventBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventBinding.inflate(inflater,container,false)


        sharedPreferences = requireActivity().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", null)


        if (token!=null){
            myMainViewModel.getEventListing(token)
        }






        eventListingResponse()
        return binding.root
    }
   private fun eventAdapter(data: List<DataEvent>) {
      val eventRecycler=  binding.RVEvent
        eventRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        var LastAdapter = EventAdapter(data)
        eventRecycler.adapter = LastAdapter
    }

    private fun eventListingResponse(){
        myMainViewModel.eventListingResponseLiveData.observe(viewLifecycleOwner){it->
            eventAdapter(it.data)
        }
    }
}