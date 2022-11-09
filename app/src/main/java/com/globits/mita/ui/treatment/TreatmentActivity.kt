package com.globits.mita.ui.treatment

import android.os.Bundle
import com.globits.mita.MitaApplication
import com.globits.mita.R
import com.globits.mita.core.MitaBaseActivity
import com.globits.mita.databinding.ActivityTreatmentBinding

import com.globits.mita.ui.patients.PatientInfoFragment
import com.globits.mita.utils.addFragment
import com.globits.mita.utils.addFragmentToBackstack
import javax.inject.Inject

class TreatmentActivity : MitaBaseActivity<ActivityTreatmentBinding>(),TreatmentViewModel.Factory {

    @Inject
    lateinit var viewModelFactory: TreatmentViewModel.Factory

    override fun getBinding(): ActivityTreatmentBinding {
        return ActivityTreatmentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MitaApplication).mitaComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        addFragment(R.id.container,TreatmentFragment::class.java)
    }
    fun addFragmentInfoPatient(){
        addFragmentToBackstack(R.id.container,TreatmentInfoPatientFragment::class.java)
    }
    fun addFragmentPatient(patientId :Int){

        var patientFragment = PatientInfoFragment()
        val args = Bundle()
        args.putInt("patientId", patientId)
        patientFragment.arguments = args
        supportFragmentManager.beginTransaction().replace(R.id.container,patientFragment).addToBackStack(null).commit()

    }
    fun removeBackStack(){
        supportFragmentManager.popBackStack()
    }

    override fun create(initialState: TreatmentViewState): TreatmentViewModel {
        return viewModelFactory.create(initialState)
    }

}
