package com.zeroone.recyclo.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.zeroone.recyclo.api.ApiInterface
import com.zeroone.recyclo.api.response.DataItem
import com.zeroone.recyclo.model.GoodsPaggingSource
import com.zeroone.recyclo.model.SessionPreference

class GoodsRepository(private val apiService: ApiInterface, private val authentication: SessionPreference) {
    fun getGoods(): LiveData<PagingData<DataItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                maxSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {  GoodsPaggingSource(apiService, authentication) }
        ).liveData
    }
}