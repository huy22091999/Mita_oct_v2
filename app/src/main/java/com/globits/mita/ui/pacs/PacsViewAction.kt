package com.globits.mita.ui.pacs

import com.globits.mita.core.MitaViewModelAction


sealed class PacsViewAction : MitaViewModelAction {

    object GetUsers : PacsViewAction()
}