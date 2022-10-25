package com.globits.mita.ui.treatment

import android.os.Bundle
import com.globits.mita.R
import com.globits.mita.core.MitaBaseActivity
import com.globits.mita.databinding.ActivityTreatmentBinding
import com.globits.mita.ui.patients.PatientInfoFragment
import com.globits.mita.utils.addFragment
import com.globits.mita.utils.addFragmentToBackstack

class TreatmentActivity : MitaBaseActivity<ActivityTreatmentBinding>() {
    override fun getBinding(): ActivityTreatmentBinding {
        return ActivityTreatmentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        addFragment(R.id.container,TreatmentFragment::class.java)
    }
    fun addFragmentInfoPatient(){
        addFragmentToBackstack(R.id.container,TreatmentFragmentInfoPatient::class.java)
    }
    fun addFragmentPatient(){
        addFragmentToBackstack(R.id.container, PatientInfoFragment::class.java, null)
    }
    fun removeBackStack(){
        supportFragmentManager.popBackStack()
    }

}
