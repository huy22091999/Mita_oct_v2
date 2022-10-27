package com.globits.mita.ui.assign

import com.globits.mita.core.MitaViewModelAction


sealed class AssignViewAction : MitaViewModelAction {

    object GetUsers : AssignViewAction()
}