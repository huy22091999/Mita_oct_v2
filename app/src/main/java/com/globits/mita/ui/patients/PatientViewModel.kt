package com.globits.mita.ui.patients

import com.airbnb.mvrx.*
import com.globits.mita.core.MitaViewModel
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter
import com.globits.mita.data.repository.TestRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


class PatientViewModel @AssistedInject constructor(
    @Assisted state: PatientViewState,
    val repository: TestRepository
) :
    MitaViewModel<PatientViewState, PatientViewAction, PatientViewEvent>(state) {
    init {
        getPatients(PatientFilter("",1,10,1))
    }

    override fun handle(action: PatientViewAction) {
        when (action) {
            is PatientViewAction.GetLabtest -> {}
            else -> {}
        }
    }

    private fun getPatients(patientFilter: PatientFilter) {
        setState {
            copy(asyncPatients= Loading())
        }
        repository.getPatient(patientFilter).execute {
            copy(asyncPatients = it)
        }
    }




    @AssistedFactory
    interface Factory {
        fun create(initialState: PatientViewState): PatientViewModel
    }

    companion object : MvRxViewModelFactory<PatientViewModel, PatientViewState> {
        @JvmStatic
        override fun create(
            viewModelContext: ViewModelContext,
            state: PatientViewState
        ): PatientViewModel {
            val factory = when (viewModelContext) {
                is FragmentViewModelContext -> viewModelContext.fragment as? Factory
                is ActivityViewModelContext -> viewModelContext.activity as? Factory
            }

            return factory?.create(state)
                ?: error("You should let your activity/fragment implements Factory interface")
        }
    }
}