package com.globits.mita.ui.nursing

import com.globits.mita.core.MitaViewModelAction
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter
import com.globits.mita.ui.assign.AssignViewAction
import com.globits.mita.ui.pacs.PacsViewAction


sealed class NursingViewAction : MitaViewModelAction {

    object GetUsers : NursingViewAction()
    data class GetPatients(var patientFilter: PatientFilter) : NursingViewAction()
    data class SetPatientDetail(var patient: Patient): NursingViewAction()
}