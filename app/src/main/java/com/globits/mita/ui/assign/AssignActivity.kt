package com.globits.mita.ui.assign

import android.os.Bundle
import com.globits.mita.R
import com.globits.mita.core.MitaBaseActivity
import com.globits.mita.databinding.ActivityAssignBinding
import com.globits.mita.utils.addFragment
import com.globits.mita.utils.addFragmentToBackstack

class AssignActivity : MitaBaseActivity<ActivityAssignBinding>() {
    override fun getBinding(): ActivityAssignBinding {
        return ActivityAssignBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        addFragment(R.id.container, AssignFragment::class.java, null)
    }

    fun addFragmentInfoPatient() {
        addFragmentToBackstack(R.id.container, AssignInfoFragment::class.java, null)
    }
    fun removeBackStack(){
        supportFragmentManager.popBackStack()
    }

}