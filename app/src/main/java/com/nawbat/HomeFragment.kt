package com.nawbat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.nawbat.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)


      binding.RvMainHome.setBackgroundResource(R.drawable.background_home)



    val navHost = childFragmentManager.findFragmentById(R.id.bottom_nav_fragment) as NavHostFragment
        val controller = navHost.navController
        binding.ArticlesLayouts.setOnClickListener {
            controller.setGraph(R.navigation.artical_nav_graph)
        }
        binding.EventsLayout.setOnClickListener {
            controller.setGraph(R.navigation.event_nav_graph)
        }
        binding.LibraryLayout.setOnClickListener {
            controller.setGraph(R.navigation.music_nav_graph)
        }
        binding.PlaylistLayout.setOnClickListener {
            controller.setGraph(R.navigation.playlist_nav_graph)
        }
        binding.HomeLayout.setOnClickListener {
            controller.setGraph(R.navigation.home2_nav_graph)
        }

        binding.imgProfile.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_accountFragment)
        }






        return binding.root
    }

}