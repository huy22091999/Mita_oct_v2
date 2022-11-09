package com.globits.mita.ui.assign

import com.globits.mita.core.MitaViewModelAction
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter


sealed class AssignViewAction : MitaViewModelAction {
    object GetUsers : AssignViewAction()
    data class SetPatientDetail(val patient: Patient) : AssignViewAction()
    data class GetPatients(val patientFilter: PatientFilter) : AssignViewAction()
    object GetLabTestAssignTemplate : AssignViewAction()
    data class GetLabTestAssign(val patientId: Long) : AssignViewAction()

}