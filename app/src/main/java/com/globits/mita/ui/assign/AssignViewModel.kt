package com.globits.mita.ui.assign

import com.airbnb.mvrx.*
import com.globits.mita.core.MitaViewModel
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter
import com.globits.mita.data.repository.TestRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


class AssignViewModel @AssistedInject constructor(
    @Assisted state: AssignViewState,
    val repository: TestRepository
) :
    MitaViewModel<AssignViewState, AssignViewAction, AssignViewEvent>(state) {
    init {
        getPatients(PatientFilter("",1,10,0))
    }

    override fun handle(action: AssignViewAction) {
        when (action) {
            is AssignViewAction.GetPatients -> getPatients(action.patientFilter)
            is AssignViewAction.SetPatientDetail -> setPatientDetail(action.patient)
            else ->{}
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
        fun create(initialState: AssignViewState): AssignViewModel
    }

    companion object : MvRxViewModelFactory<AssignViewModel, AssignViewState> {
        @JvmStatic
        override fun create(
            viewModelContext: ViewModelContext,
            state: AssignViewState
        ): AssignViewModel {
            val factory = when (viewModelContext) {
                is FragmentViewModelContext -> viewModelContext.fragment as? Factory
                is ActivityViewModelContext -> viewModelContext.activity as? Factory
            }

            return factory?.create(state)
                ?: error("You should let your activity/fragment implements Factory interface")
        }
    }
}