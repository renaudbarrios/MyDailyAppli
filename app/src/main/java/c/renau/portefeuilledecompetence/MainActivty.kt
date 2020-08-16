package c.renau.portefeuilledecompetence

import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener
 {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        displayScreen(-1)


    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    fun displayScreen(id: Int){
        val fragment= when(id){
            R.id.nav_accueil ->{
                AccueilFragment()
            }
            R.id.nav_cv ->{
                CvFragment()
            }
            R.id.nav_ppe1 ->{
                Ppe1Fragment()
            }
            R.id.nav_ppe2 ->{
                Ppe2Fragment()
            }
            R.id.nav_stage1 ->{
                Stage1Fragment()
            }
            R.id.nav_stage2 -> {
                Stage2Fragment()
            }
            R.id.nav_notes -> {
                NotesFragment()
            }
            R.id.nav_hobbies -> {
                HobbiesFragment()
            }
                else ->{
                AccueilFragment()
            }
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.relativeLayout,fragment)
            .commit()
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayScreen(item.itemId)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}