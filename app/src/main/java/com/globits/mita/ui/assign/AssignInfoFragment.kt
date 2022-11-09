package com.globits.mita.ui.assign

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.labtestassign.LabTestAssign
import com.globits.mita.ui.assign.AssignViewEvent.*
import com.globits.mita.ui.assign.view.SetLayoutPatientInfoAssign
import javax.inject.Inject


class AssignInfoFragment : MitaBaseFragment() {

    val viewModel: AssignViewModel by activityViewModel()
    var patient = mutableStateOf<Patient>(Patient())
    var isGetLabTestAssign: Boolean = true
    var listLabTest: MutableState<List<LabTestAssign>> = mutableStateOf(mutableListOf())

    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfoAssign(onBackStack = {
            (activity as AssignActivity).removeBackStack()
        }, patient.value)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.observeViewEvents {
            handleViewEvent(it)
        }
    }

    private fun handleViewEvent(it: AssignViewEvent?) {
        when (it) {
            GetLabTestAssignEvent -> {
                withState(viewModel) {
                    when (it.asyncLabTestAssign) {
                        is Success -> {
                            it.asyncLabTestAssign.invoke().let {
                                listLabTest.value = it
                            }
                        }

                        else -> {

                        }
                    }
                }
            }

            else -> {}
        }
    }


    override fun invalidate(): Unit = withState(viewModel) {
        it.patient.also { it ->
            if (it != null) {
                patient.value = it
                if (isGetLabTestAssign) {
                    it.id?.let {
                        viewModel.handle(AssignViewAction.GetLabTestAssign(it))
                    }
                    isGetLabTestAssign = false
                }
            }
        }


    }

}