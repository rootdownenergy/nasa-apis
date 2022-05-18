package com.rootdown.dev.nasaneorebase.ui.feature_creator

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.carousel
import com.google.android.material.snackbar.Snackbar
import com.rootdown.dev.nasaneorebase.MediaCarouselBindingModel_
import com.rootdown.dev.nasaneorebase.NeoCarouselBindingModel_
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorMediaEntity
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorNeoEntity
import com.rootdown.dev.nasaneorebase.databinding.FragmentCreatorBinding
import com.rootdown.dev.nasaneorebase.title
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CreatorFragment : Fragment() {

    private lateinit var binding: FragmentCreatorBinding
    private val vmActivity: CreatorViewModel by activityViewModels()
    private var searchJob: Job? = null
    private var lsNeo: List<CreatorNeoEntity> = listOf()
    private var lsMedia: List<CreatorMediaEntity> = listOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreatorBinding.inflate(inflater)
        searchJob
        val epoxyView: EpoxyRecyclerView = binding.rvCreator
        setupEpoxy(epoxyView,lsNeo,lsMedia)
        return binding.root
    }

    private fun search() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            vmActivity.creatorMediaFlow?.collectLatest {
                lsMedia = it
            }
            vmActivity.creatorNeoFlow?.collectLatest {
                lsNeo = it
            }
        }
    }


    private fun setupEpoxy(epoxy: EpoxyRecyclerView, lsNeo: List<CreatorNeoEntity>, lsMedia: List<CreatorMediaEntity>) {

        epoxy.withModels {
            title {
                id("title-neo")
                title("Near Earth Objects")
            }
            val carouselItemNeoModels = lsNeo.map { x ->
                NeoCarouselBindingModel_()
                    .id(x.neoId.toLong())
                    .carouselItem(x)
                    .clickListener { i ->
                        showSnackBar("${x.name}", requireActivity())
                    }
            }
            val carouselItemMediaModels = lsMedia.map { x ->
                MediaCarouselBindingModel_()
                    .id(x.mediaId.toLong())
                    .carouselItem(x)
                    .clickListener { i ->
                        showSnackBar("${x.title}", requireActivity())
                    }
            }
            carousel {
                id("media-carousel")
                models(carouselItemMediaModels)
                id("neo-carousel")
                models(carouselItemNeoModels)
            }
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