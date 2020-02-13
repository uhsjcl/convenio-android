package com.anshaysaboo.convenio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navDrawer: DrawerLayout
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBar()
    }

    // complete setup for navigation drawer and toolbar
    fun setupActionBar() {
        // setup toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        navDrawer = findViewById(R.id.drawer_layout)
        drawerToggle = ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.drawer_open,  R.string.drawer_closed);
        drawerToggle.syncState()

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            navDrawer.closeDrawers()

            // display the fragment
            displayFragmentFromMenuItem(menuItem)

            true
        }

        navDrawer.addDrawerListener(drawerToggle)
    }

    // show a new fragment based on the selected menu item
    fun displayFragmentFromMenuItem(menuItem: MenuItem) {
        var fragment: Fragment? = null
        when (menuItem.itemId) {
            R.id.nav_feed -> {
                fragment = FeedFragment()
            }
            R.id.nav_schedule -> {
                fragment = ScheduleFragment()
            }
            R.id.nav_map -> {
                fragment = MapFragment()
            }
        }

        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.content_frame, fragment)

            setTitle(menuItem.title)

            transaction.commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                navDrawer.openDrawer(GravityCompat.START)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
