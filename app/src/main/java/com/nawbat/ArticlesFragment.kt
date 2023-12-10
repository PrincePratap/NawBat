package com.nawbat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nawbat.Adapters.ArticlesAdapters
import com.nawbat.MVVM.APIs.Articles.DataArticles
import com.nawbat.MVVM.ViewModel.MyMainViewModel
import com.nawbat.databinding.FragmentArticlesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ArticlesFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences


    @Inject
    lateinit var myMainViewModel: MyMainViewModel



    private lateinit var binding: FragmentArticlesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticlesBinding.inflate(inflater,container,false)


        sharedPreferences = requireActivity().getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", null)

        if(token!=null){
            myMainViewModel.getArticleListingResponse(token)
        }





        articleServiceResponse()


        return binding.root
    }

    fun articleServiceResponse(){
        myMainViewModel.articleListingResponseLiveData.observe(viewLifecycleOwner){
            articlesAdaptersFun(it.data)
        }
    }

    fun articlesAdaptersFun(list: List<DataArticles>) {
        val articlesRecyclerView = binding.RVArticle
        articlesRecyclerView.layoutManager = LinearLayoutManager(context)
        articlesRecyclerView.setHasFixedSize(true)
        val ArticlesAdapters = ArticlesAdapters(list)
        articlesRecyclerView.adapter = ArticlesAdapters
    }
}