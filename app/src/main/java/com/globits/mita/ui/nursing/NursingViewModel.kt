package com.globits.mita.ui.nursing

import com.airbnb.mvrx.*
import com.globits.mita.core.MitaViewModel
import com.globits.mita.data.repository.TestRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


class NursingViewModel @AssistedInject constructor(
    @Assisted state: NursingViewState,
    val repository: TestRepository
) :
    MitaViewModel<NursingViewState, NursingViewAction, NursingViewEvent>(state) {
    init {
        handleGetUsers()
    }

    override fun handle(action: NursingViewAction) {
        when (action) {
            is NursingViewAction.GetUsers -> handleGetUsers()
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
        fun create(initialState: NursingViewState): NursingViewModel
    }

    companion object : MvRxViewModelFactory<NursingViewModel, NursingViewState> {
        @JvmStatic
        override fun create(
            viewModelContext: ViewModelContext,
            state: NursingViewState
        ): NursingViewModel {
            val factory = when (viewModelContext) {
                is FragmentViewModelContext -> viewModelContext.fragment as? Factory
                is ActivityViewModelContext -> viewModelContext.activity as? Factory
            }

            return factory?.create(state)
                ?: error("You should let your activity/fragment implements Factory interface")
        }
    }
}