package com.globits.mita.ui.home


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.ui.MainActivity
import com.globits.mita.ui.assign.AssignActivity
import com.globits.mita.ui.nursing.NursingActivity
import com.globits.mita.ui.pacs.PacsActivity
import com.globits.mita.ui.treatment.TreatmentActivity
import java.util.*
import javax.inject.Inject

class HomeFragment @Inject constructor() : MitaBaseFragment() {
    private val viewModel: HomeViewModel by activityViewModel()

    @Composable
    override fun SetLayout() {
        setLayoutFragment(
            requireContext(),
            onClickListNursing = {
                (activity as MainActivity).startActivity(
                    Intent(
                        requireContext(),
                        NursingActivity::class.java
                    )
                )
            },
            onClickListTreatment = {
                (activity as MainActivity).startActivity(
                    Intent(
                        requireContext(),
                        TreatmentActivity::class.java
                    )
                )
            },
            onClickListPacs = {
                (activity as MainActivity).startActivity(
                    Intent(
                        requireContext(),
                        PacsActivity::class.java
                    )
                )
            },
            onClickListAssign = {
                (activity as MainActivity).startActivity(
                    Intent(
                        requireContext(),
                        AssignActivity::class.java
                    )
                )
            },
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observeViewEvents {
            handleEvent(it)
        }
        viewModel.handle(HomeViewAction.GetAnalytics)
        setListener()
    }

    private fun handleEvent(event: HomeViewEvent) {
        when {

        }
    }

    private fun setListener() {

    }

    override fun invalidate() = withState(viewModel) {

    }

}

data class Daily(
    val time: Calendar,
    val doctorName: String,
    val depcription: String,
)