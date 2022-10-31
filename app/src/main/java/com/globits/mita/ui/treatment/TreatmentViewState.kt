package com.globits.mita.ui.treatment

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.globits.mita.data.model.Responsive
import com.globits.mita.data.model.User
import com.globits.mita.data.network.UserDto

data class TreatmentViewState(
    var asyncUsers: Async<Responsive<List<UserDto>>> = Uninitialized
) : MvRxState {
    fun isLoading() = asyncUsers is Loading
}