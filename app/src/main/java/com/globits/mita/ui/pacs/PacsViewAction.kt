package com.globits.mita.ui.pacs

import com.globits.mita.core.MitaViewModelAction
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter
import com.globits.mita.ui.assign.AssignViewAction


sealed class PacsViewAction : MitaViewModelAction {

    object GetUsers : PacsViewAction()
    data class SetPatientDetail(var patient: Patient): PacsViewAction()
    data class GetPatients(var patientFilter: PatientFilter) : PacsViewAction()
}