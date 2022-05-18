package com.rootdown.dev.nasaneorebase.ui.feature_nasa_media

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.airbnb.epoxy.EpoxyRecyclerView
import com.google.android.material.snackbar.Snackbar
import com.rootdown.dev.nasaneorebase.data.model.remote.MediaRoot
import com.rootdown.dev.nasaneorebase.databinding.FragmentMediaBinding
import com.rootdown.dev.nasaneorebase.di.util.MainDispatcher
import com.rootdown.dev.nasaneorebase.media
import com.rootdown.dev.nasaneorebase.ui.feature_creator.CreatorViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MediaFragment : Fragment() {
    private lateinit var binding: FragmentMediaBinding
    private val vm: MediaViewModel by viewModels()
    private val vmActivity: CreatorViewModel by activityViewModels()

    private var dbSave: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMediaBinding.inflate(inflater)
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
                    clickListener { xix ->
                        showSnackBar("Current Id: ${xx?.data?.first().toString()}", requireActivity())

                    }
                }
            }
            Log.w("UIUI", links.toString())
        }
    }
    private fun mediaSave(){
        dbSave?.cancel()
        dbSave = lifecycleScope.launch {

        }
    }

    private fun showSnackBar(message: String?, activity: Activity?) {
        if (null != activity && null != message) {
            Snackbar.make(
                activity.findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}