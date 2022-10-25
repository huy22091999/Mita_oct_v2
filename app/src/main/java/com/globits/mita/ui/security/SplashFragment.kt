package com.globits.mita.ui.security

import android.view.LayoutInflater
import android.view.ViewGroup
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentSplassBinding
import javax.inject.Inject

class SplashFragment @Inject constructor() : MitaBaseFragment<FragmentSplassBinding>() {
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplassBinding {
        return FragmentSplassBinding.inflate(inflater,container,false)
    }

}