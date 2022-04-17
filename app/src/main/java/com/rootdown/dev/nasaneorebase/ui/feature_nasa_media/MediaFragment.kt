package com.rootdown.dev.nasaneorebase.ui.feature_nasa_media

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.airbnb.epoxy.EpoxyRecyclerView
import com.rootdown.dev.nasaneorebase.data.model.remote.Media
import com.rootdown.dev.nasaneorebase.databinding.FragmentMediaBinding
import com.rootdown.dev.nasaneorebase.media
import com.rootdown.dev.nasaneorebase.neo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MediaFragment : Fragment() {
    private lateinit var binding: FragmentMediaBinding
    private val vm: MediaViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMediaBinding.inflate(inflater)
        val epoxyView: EpoxyRecyclerView = binding.rvMedia
        vm.result.observe(viewLifecycleOwner, Observer {
            it?.let {
                val data = it.getIt()
                Log.w("NET", data.toString())
                if (it.handled){
                    val ls: List<Media.Collection.Item.Data> = (data.data?.collection?.items as List<Media.Collection.Item.Data>?)!!
                    setupEpoxy(ls,epoxyView)
                }
            }
        })
        return binding.root
    }
    private fun setupEpoxy(result: List<Media.Collection.Item.Data>, epoxy: EpoxyRecyclerView){
        val xLs = result
        vm.predaciteNum = xLs.size
        epoxy.withModels {
            xLs.forEach { ii ->
                Log.w("!!!", ii.toString())
                vm.makeIds(vm.predaciteNum)
                media {
                    id(vm.count)
                    xx(ii)
                }
            }
        }
    }
}