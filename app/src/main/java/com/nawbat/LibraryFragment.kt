package com.nawbat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nawbat.Adapters.MusicAdapters
import com.nawbat.MVVM.APIs.Music.DataMusic
import com.nawbat.MVVM.ViewModel.MyMainViewModel
import com.nawbat.databinding.FragmentLibraryBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LibraryFragment : Fragment() {


    private lateinit var sharedPreferences: SharedPreferences


    @Inject
    lateinit var myMainViewModel: MyMainViewModel

    private lateinit var binding: FragmentLibraryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLibraryBinding.inflate(inflater, container, false)


        sharedPreferences =
            requireActivity().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", null)


        if (token != null) {
            myMainViewModel.getMusicListing(token)
        }


        musicListingResponseFun()




        return binding.root
    }

    fun musicListingResponseFun() {
        myMainViewModel.musicListingResponseLiveData.observe(viewLifecycleOwner) { it ->
            musicAdapter(it.data)
        }
    }

    private fun musicAdapter(list : List<DataMusic>) {
            val musicRecyclerView = binding.RvMusic
            musicRecyclerView.layoutManager = GridLayoutManager(context, 2)
            musicRecyclerView.setHasFixedSize(true)
            val ArticlesAdapters = MusicAdapters(list)
            musicRecyclerView.adapter = ArticlesAdapters

    }
}