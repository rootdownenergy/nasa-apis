package com.rootdown.dev.nasaneorebase.ui.feature_nasa_neo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.airbnb.epoxy.EpoxyRecyclerView
import com.google.android.material.snackbar.Snackbar
import com.rootdown.dev.nasaneorebase.data.model.remote.Neo
import com.rootdown.dev.nasaneorebase.databinding.FragmentNeoBinding
import com.rootdown.dev.nasaneorebase.neo
import com.rootdown.dev.nasaneorebase.ui.feature_creator.CreatorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NeoFragment : Fragment() {
    private lateinit var binding: FragmentNeoBinding
    private val vm: NeoViewModel by viewModels()
    private val vmActivity: CreatorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNeoBinding.inflate(inflater)
        val epoxyView: EpoxyRecyclerView = binding.rvNeo
        vm.result.observe(viewLifecycleOwner){
            val ls = it.getIt().data
            Log.w("BBB", ls.toString())
            if (ls != null) {
                Log.w("UI2", ls.toString())
                setupEpoxy(ls,epoxyView)
            }
        }

        return binding.root
    }
    private fun setupEpoxy(ls: List<Neo>,epoxy: EpoxyRecyclerView){
        val xLs = ls
        vm.predaciteNum = xLs.size
        epoxy.withModels {
            xLs.forEach { xx ->
                vm.makeIds(vm.predaciteNum)
                neo {
                    id(vm.count)
                    xx(xx)
                    clickListener { xix ->
                        showSnackBar("Current Id: ${xx.name}", requireActivity())
                    }
                }
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