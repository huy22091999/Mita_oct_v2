package com.globits.mita.ui.assign

import com.globits.mita.core.MitaViewModelAction
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter


sealed class AssignViewAction : MitaViewModelAction {

    object GetUsers : AssignViewAction()
    data class SetPatientDetail(var patient: Patient ): AssignViewAction()
    data class GetPatients(var patientFilter: PatientFilter) : AssignViewAction()
}