package com.globits.mita.ui.nursing

import android.os.Bundle
import com.globits.mita.R
import com.globits.mita.core.MitaBaseActivity
import com.globits.mita.databinding.ActivityNursingBinding
import com.globits.mita.ui.patients.PatientInfoFragment
import com.globits.mita.utils.addFragment
import com.globits.mita.utils.addFragmentToBackstack

class NursingActivity : MitaBaseActivity<ActivityNursingBinding>() {
    override fun getBinding(): ActivityNursingBinding {
        return ActivityNursingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        addFragment(R.id.container, NursingFragment::class.java, null)
    }
    fun addFragmentInfoPatient(){
        addFragmentToBackstack(R.id.container, NursingFragmentInfoPatient::class.java, null)
    }
    fun addFragmentPatient(){
        addFragmentToBackstack(R.id.container, PatientInfoFragment::class.java, null)
    }
    fun removeBackStack(){
        supportFragmentManager.popBackStack()
    }


}