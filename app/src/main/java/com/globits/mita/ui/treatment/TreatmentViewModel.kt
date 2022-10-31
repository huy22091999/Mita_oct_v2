package com.globits.mita.ui.treatment

import com.airbnb.mvrx.*
import com.globits.mita.core.MitaViewModel
import com.globits.mita.data.repository.TestRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


class TreatmentViewModel @AssistedInject constructor(
    @Assisted state: TreatmentViewState,
    val repository: TestRepository
) :
    MitaViewModel<TreatmentViewState, TreatmentViewAction, TreatmentViewEvent>(state) {
    init {
        handleGetUsers()
    }

    override fun handle(action: TreatmentViewAction) {
        when (action) {
            is TreatmentViewAction.GetUsers -> handleGetUsers()
        }
    }

    private fun handleGetUsers() {
        setState { copy(asyncUsers = Loading()) }
        repository.getCurrentUser().execute {
            copy(asyncUsers = it)
        }
    }


    @AssistedFactory
    interface Factory {
        fun create(initialState: TreatmentViewState): TreatmentViewModel
    }

    companion object : MvRxViewModelFactory<TreatmentViewModel, TreatmentViewState> {
        @JvmStatic
        override fun create(
            viewModelContext: ViewModelContext,
            state: TreatmentViewState
        ): TreatmentViewModel {
            val factory = when (viewModelContext) {
                is FragmentViewModelContext -> viewModelContext.fragment as? Factory
                is ActivityViewModelContext -> viewModelContext.activity as? Factory
            }

            return factory?.create(state)
                ?: error("You should let your activity/fragment implements Factory interface")
        }
    }
}