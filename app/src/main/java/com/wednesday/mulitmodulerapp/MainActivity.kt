package com.wednesday.mulitmodulerapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.core.os.bundleOf
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.wednesday.core_database.di.databaseModule
import com.wednesday.core_navigation.di.navigationModule
import com.wednesday.core_network.di.networkModule
import com.wednesday.core_repository.di.repositoryModule
import com.wednesday.feature_search.di.searchModule
import com.wednesday.feature_weather.di.weatherModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import com.wednesday.core_common.databinding.ActivityMainBinding
import com.wednesday.core_presentation.R
import com.wednesday.feature_weather.presentation.HomeScreen

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        installSplashScreen()

        super.onCreate(savedInstanceState)
//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }

        startKoin {
            androidContext(applicationContext)
            modules(
                databaseModule,
                networkModule,
                navigationModule,
                repositoryModule,
                searchModule,
                weatherModule
            )
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        displayFragment()
        setContentView(binding.root)
    }

    @SuppressLint("ResourceType")
    private fun displayFragment() {
        val (graph, controller) = getNavGraphWithController(
            binding.mainNavHostFragment.id,
            R.navigation.nav_main
        )

        val startScreen = HomeScreen

        graph.setup(
            controller,
            R.id.startFragment,
            bundleOf("key_args" to startScreen)
        )
    }

    private fun NavGraph.setup(
        navController: NavController,
        startDestId: Int,
        startDestinationArgs: Bundle? = null
    ) {
        setStartDestination(startDestId)
        if (startDestinationArgs != null) {
            navController.setGraph(this, startDestinationArgs)
        } else {
            navController.graph = this
        }
    }

    private fun FragmentActivity.getNavGraphWithController(
        @IdRes navHostFragmentId: Int,
        @NavigationRes navGraphId: Int
    ): NavGraphWithController {
        val navHost =
            supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
        val navController = navHost.findNavController()
        val navInflater = navController.navInflater
        val graph = navInflater.inflate(navGraphId)

        return NavGraphWithController(graph, navController)
    }

    private data class NavGraphWithController(
        val graph: NavGraph,
        val controller: NavController
    )
}