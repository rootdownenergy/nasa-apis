package com.rootdown.dev.nasaneorebase.ui.feature_nasa_media

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.airbnb.epoxy.EpoxyRecyclerView
import com.rootdown.dev.nasaneorebase.data.model.remote.MediaRoot
import com.rootdown.dev.nasaneorebase.databinding.FragmentMediaBinding
import com.rootdown.dev.nasaneorebase.media
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MediaFragment : Fragment() {
    private lateinit var binding: FragmentMediaBinding
    private val vm: MediaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMediaBinding.inflate(inflater)
        binding.viewModel = vm
        binding.lifecycleOwner = viewLifecycleOwner
        val epoxyView: EpoxyRecyclerView = binding.rvMedia
        vm.result.observe(viewLifecycleOwner) {
            val xx = it.getIt().data?.collection?.items
            Log.w("XXX", xx.toString())
            if(xx != null){
                setupEpoxy(xx,epoxyView)
            }
        }
        return binding.root
    }
    private fun setupEpoxy(ls: List<MediaRoot.Collection.Item?>, epoxy: EpoxyRecyclerView){
        val xLs = ls
        vm.predaciteNum = xLs.size
        val links: MutableList<MediaRoot.Collection.Item.Link> = mutableListOf()
        epoxy.withModels {
            xLs.forEach { xx ->
                xx?.links?.first()?.let { links.add(it) }
                Log.w("UIUI", xx?.data?.first().toString())
                vm.makeIds(vm.predaciteNum)
                media {
                    id(vm.count)
                    xx(xx?.data?.first())
                    x(xx?.links?.first())
                }
            }
            Log.w("UIUI", links.toString())
        }
    }
}