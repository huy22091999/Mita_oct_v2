package com.globits.mita.ui.nursing

import com.airbnb.mvrx.*
import com.globits.mita.core.MitaViewModel
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter
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
        getPatients(PatientFilter("",1,10,0))
    }

    override fun handle(action: NursingViewAction) {
        when (action) {
            is NursingViewAction.GetPatients -> getPatients(action.patientFilter)
            is NursingViewAction.SetPatientDetail -> setPatientDetail(action.patient)
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