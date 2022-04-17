package com.rootdown.dev.nasaneorebase.ui.feature_nasa_neo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.airbnb.epoxy.EpoxyRecyclerView
import com.rootdown.dev.nasaneorebase.data.model.remote.Neo
import com.rootdown.dev.nasaneorebase.databinding.FragmentNeoBinding
import com.rootdown.dev.nasaneorebase.neo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NeoFragment : Fragment() {
    private lateinit var binding: FragmentNeoBinding
    private val vm: NeoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNeoBinding.inflate(inflater)
        val epoxyView: EpoxyRecyclerView = binding.rvNeo
        vm.result.observe(viewLifecycleOwner, Observer {
            it?.let {
                val data = it.getIt()
                Log.w("UI", data.toString())
                val ls = data.data?.nearEarthObjects
                Log.w("UI",ls.toString())
                //setupEpoxy(ls,epoxyView)
            }
        })
        return binding.root
    }
    private fun setupEpoxy(result: List<Neo>, epoxy: EpoxyRecyclerView){
        val xLs = result
        vm.predaciteNum = xLs.size
        epoxy.withModels {
            result.forEach { ii ->
                vm.makeIds(vm.predaciteNum)
                neo {
                    id(vm.count)
                    xx(ii)
                }
            }
        }
    }
}