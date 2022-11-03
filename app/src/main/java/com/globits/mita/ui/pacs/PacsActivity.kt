package com.globits.mita.ui.pacs

import android.os.Bundle
import com.globits.mita.R
import com.globits.mita.core.MitaBaseActivity
import com.globits.mita.databinding.ActivityPacsBinding
import com.globits.mita.utils.addFragment
import com.globits.mita.utils.addFragmentToBackstack

class PacsActivity : MitaBaseActivity<ActivityPacsBinding>() {
    override fun getBinding(): ActivityPacsBinding {
        return ActivityPacsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        addFragment(R.id.container, PacsFragment::class.java)
    }

    fun addFragmentInfoPatient() {
        addFragmentToBackstack(R.id.container, PacsInfoFragment::class.java)
    }

    fun addFragmentImage() {
        addFragmentToBackstack(R.id.container, PacsImageFragment::class.java)
    }


    fun removeBackStack(){
        supportFragmentManager.popBackStack()
    }


}