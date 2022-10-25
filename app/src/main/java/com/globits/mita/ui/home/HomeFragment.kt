package com.globits.mita.ui.home


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.R
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentHomeBinding
import com.globits.mita.ui.MainActivity
import com.globits.mita.ui.assign.AssignActivity
import com.globits.mita.ui.nursing.NursingActivity
import com.globits.mita.ui.pacs.PacsActivity
import com.globits.mita.ui.treatment.TreatmentActivity
import java.util.*
import javax.inject.Inject

class HomeFragment @Inject constructor() : MitaBaseFragment<FragmentHomeBinding>() {
    private val viewModel: HomeViewModel by activityViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.container.setContent {
            setLayoutFragment(
                requireContext(),
                onClickListNursing = {
                    (activity as MainActivity).startActivity(Intent(requireContext(),NursingActivity::class.java))
                },
                onClickListTreatment = {
                    (activity as MainActivity).startActivity(Intent(requireContext(),TreatmentActivity::class.java))
                },
                onClickListPacs = {
                    (activity as MainActivity).startActivity(Intent(requireContext(),PacsActivity::class.java))
                },
                onClickListAssign = {
                    (activity as MainActivity).startActivity(Intent(requireContext(),AssignActivity::class.java))
                },
            )
        }
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

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
         return FragmentHomeBinding.inflate(inflater, container, false)
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