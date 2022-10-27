package com.globits.mita.data.repository

import com.globits.mita.data.model.Responsive
import com.globits.mita.data.network.SearchDto
import com.globits.mita.data.network.TestApi
import com.globits.mita.data.network.UserDto
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepository @Inject constructor(
    val api: TestApi
) {
    fun getCurrentUser(): Observable<Responsive<List<UserDto>>> =
        api.search(SearchDto("", "")).subscribeOn(Schedulers.io())
}