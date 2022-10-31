package com.globits.mita.ui.treatment

import com.globits.mita.core.MitaViewModelAction


sealed class TreatmentViewAction : MitaViewModelAction {

    object GetUsers : TreatmentViewAction()
}