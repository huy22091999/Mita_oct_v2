package com.globits.mita.ui


import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.airbnb.mvrx.viewModel
import com.globits.mita.R

import com.globits.mita.MitaApplication
import com.globits.mita.core.MitaBaseActivity
import com.globits.mita.databinding.ActivityMainBinding
import com.globits.mita.ui.home.HomeViewModel
import com.globits.mita.ui.home.HomeViewState
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject


class MainActivity : MitaBaseActivity<ActivityMainBinding>(), HomeViewModel.Factory {
    private lateinit var appBarConfiguration: AppBarConfiguration
    val viewModel: HomeViewModel by viewModel()

    @Inject
    lateinit var viewModelFactory: HomeViewModel.Factory

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MitaApplication).mitaComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        val navView: BottomNavigationView = views.navView
        navController = findNavController(R.id.navigate)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_note,
                R.id.nav_notification,
                R.id.nav_setting
            ), null
        )
        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        viewModel.subscribe(this){
            if(it.isLoading())
            {
                views.waitingView.waitingView.visibility= View.VISIBLE
            }
            else{
                views.waitingView.waitingView.visibility= View.GONE
            }
        }
    }

    fun setupToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setupActionBarWithNavController(navController, appBarConfiguration)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    //    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.navigate)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
    override fun getBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun create(initialState: HomeViewState): HomeViewModel {
        return viewModelFactory.create(initialState)
    }

    fun navigateTo(fragmentId: Int) {
        navController.navigate(fragmentId)
    }




}

