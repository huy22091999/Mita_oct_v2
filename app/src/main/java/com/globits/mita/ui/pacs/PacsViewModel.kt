package com.globits.mita.ui.pacs

import com.airbnb.mvrx.*
import com.globits.mita.core.MitaViewModel
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter
import com.globits.mita.data.repository.TestRepository
import com.globits.mita.ui.assign.AssignViewAction
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


class PacsViewModel @AssistedInject constructor(
    @Assisted state: PacsViewState,
    val repository: TestRepository
) :
    MitaViewModel<PacsViewState, PacsViewAction, PacsViewEvent>(state) {
    init {
        getPatients(PatientFilter("",1,10,1))
    }

    override fun handle(action: PacsViewAction) {
        when (action) {
            is PacsViewAction.GetPatients -> getPatients(action.patientFilter)
            is PacsViewAction.SetPatientDetail -> setPatientDetail(action.patient)
            else -> {}
        }
    }

    private fun setPatientDetail(patient: Patient) {
        setState { copy(patient=patient)}
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