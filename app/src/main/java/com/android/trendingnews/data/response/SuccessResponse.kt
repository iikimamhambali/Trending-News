package com.android.trendingnews.data.response

data class SuccessResponse<T>(val body: T) : ApiResponse<T>()