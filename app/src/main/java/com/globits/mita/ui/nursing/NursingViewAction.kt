package com.globits.mita.ui.nursing

import com.globits.mita.core.MitaViewModelAction


sealed class NursingViewAction : MitaViewModelAction {

    object GetUsers : NursingViewAction()
}