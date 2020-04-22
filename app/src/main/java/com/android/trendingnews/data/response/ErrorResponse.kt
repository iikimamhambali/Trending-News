package com.android.trendingnews.data.response

data class ErrorResponse<T>(
    val errorCode: Int,
    val error: Throwable
) : ApiResponse<T>()