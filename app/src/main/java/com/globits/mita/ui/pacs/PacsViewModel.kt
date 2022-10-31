package com.globits.mita.ui.pacs

import com.airbnb.mvrx.*
import com.globits.mita.core.MitaViewModel
import com.globits.mita.data.repository.TestRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


class PacsViewModel @AssistedInject constructor(
    @Assisted state: PacsViewState,
    val repository: TestRepository
) :
    MitaViewModel<PacsViewState, PacsViewAction, PacsViewEvent>(state) {
    init {
        handleGetUsers()
    }

    override fun handle(action: PacsViewAction) {
        when (action) {
            is PacsViewAction.GetUsers -> handleGetUsers()
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
        fun create(initialState: PacsViewState): PacsViewModel
    }

    companion object : MvRxViewModelFactory<PacsViewModel, PacsViewState> {
        @JvmStatic
        override fun create(
            viewModelContext: ViewModelContext,
            state: PacsViewState
        ): PacsViewModel {
            val factory = when (viewModelContext) {
                is FragmentViewModelContext -> viewModelContext.fragment as? Factory
                is ActivityViewModelContext -> viewModelContext.activity as? Factory
            }

            return factory?.create(state)
                ?: error("You should let your activity/fragment implements Factory interface")
        }
    }
}