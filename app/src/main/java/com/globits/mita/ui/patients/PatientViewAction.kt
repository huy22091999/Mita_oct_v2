package com.globits.mita.ui.patients

import com.globits.mita.core.MitaViewModelAction
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter


sealed class PatientViewAction : MitaViewModelAction {

    object GetLabtest : PatientViewAction()
}