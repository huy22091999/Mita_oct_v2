package com.globits.mita.data.network

import com.globits.mita.data.model.Responsive
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST


interface TestApi {
    @POST("employees/search")
    fun search(@Body dto: SearchDto): Observable<Responsive<List<UserDto>>>
}

data class SearchDto(
    val code: String,
    val name: String
)

data class UserDto(
    val id: String? = null,
    val name: String? = null,
    val code: String? = null,
    val age: Int? = 0,
    val status :Int? = null,
)