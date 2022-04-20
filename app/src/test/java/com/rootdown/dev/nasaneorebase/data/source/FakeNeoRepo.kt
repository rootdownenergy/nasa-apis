package com.rootdown.dev.nasaneorebase.data.source

import androidx.lifecycle.MutableLiveData
import com.rootdown.dev.nasaneorebase.data.model.remote.Neo
import com.rootdown.dev.nasaneorebase.data.repo.NeoRepo
import com.rootdown.dev.nasaneorebase.domain.model.Resource

class FakeNeoRepo : NeoRepo {
    private val neoResponse = mutableListOf<Neo>()
    private val observableData = MutableLiveData<List<Neo>>()
    private val neoTest1 = Neo(id = "1", refId = "1212", name = "TDD", url = "soap.tdd.com")
    private val neoTest2 = Neo(id = "2", refId = "112334", name = "TDD-212", url = "soap.tdd.com")
    private val neoTest3 = Neo(id = "3", refId = "11422", name = "TDD-124", url = "soap.tdd.com")

    init {
        neoResponse.add(neoTest1)
        neoResponse.add(neoTest2)
        neoResponse.add(neoTest3)
    }
    override suspend fun getNeo(): Resource<List<Neo>> {
        return  Resource.success(neoResponse.toList())
    }
}