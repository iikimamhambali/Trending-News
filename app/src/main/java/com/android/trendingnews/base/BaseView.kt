package com.android.trendingnews.base

import android.os.Bundle
import com.android.trendingnews.data.response.Resource
import com.android.trendingnews.data.response.StatusState

interface BaseView {

    fun getLayoutResId(): Int

    fun initView(savedInstanceState: Bundle?)

    fun initEvent()

    fun loadingData(isFromSwipe: Boolean = false)

    fun observeData()

    /**
     * Group function show and gone UI view progress bar
     */

    fun startLoading()

    fun stopLoading()

    /**
     * Group function show and gone state view
     */

    fun onInternetError()

    fun onDataNotFound()

    fun onError(throwable: Throwable? = null)

    fun <T> parseObserveData(
        resource: Resource<T>,
        resultLoading: (T?) -> Unit = { startLoading() },
        resultSuccess: (T, T) -> Unit = { _, _ -> },
        resultNetworkFailed: (Throwable?) -> Unit = { onInternetError() },
        resultDataNotFound: (Throwable?) -> Unit = { onDataNotFound() },
        resultError: (Throwable?) -> Unit = { onError(it) }
    ) {
        when (resource.status) {
            StatusState.Loading -> {
                resultLoading(resource.data)
            }
            StatusState.Success -> {
                stopLoading()
                resource.data?.let { resultSuccess(it, it) }
            }
            StatusState.NetworkFailed -> {
                stopLoading()
                resultNetworkFailed(resource.throwable)
            }
            StatusState.NotFound -> {
                stopLoading()
                resultDataNotFound(resource.throwable)
            }
            StatusState.UnknownError -> {
                stopLoading()
                resultError(resource.throwable)
            }
        }
    }
}