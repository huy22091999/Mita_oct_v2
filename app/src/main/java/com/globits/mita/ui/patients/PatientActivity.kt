package com.globits.mita.ui.patients

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.globits.mita.core.MitaBaseActivity
import com.globits.mita.databinding.ActivityPatientBinding

class PatientActivity : MitaBaseActivity<ActivityPatientBinding>() {
    override fun getBinding(): ActivityPatientBinding {
        return ActivityPatientBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
    }

}