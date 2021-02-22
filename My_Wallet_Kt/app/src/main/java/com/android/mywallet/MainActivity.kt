package com.android.mywallet

import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration


    private lateinit var amount_home : EditText
    private lateinit var amount_reminder : EditText
    private lateinit var balance : TextView
    private lateinit var income : TextView
    private lateinit var expence : TextView
    private lateinit var usage : TextView
    private lateinit var add_home : ImageButton
    private lateinit var sub_home : ImageButton
    private lateinit var add_reminder : ImageButton
    private lateinit var sub_reminder : ImageButton
    private lateinit var submit : Button
    private lateinit var delete : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun main(args: Array<String>){

        amount_home = findViewById(R.id.amount_home)
        amount_reminder = findViewById(R.id.amount_reminder)
        balance = findViewById(R.id.balance)
        income = findViewById(R.id.income)
        expence = findViewById(R.id.expence)
        usage = findViewById(R.id.usage)
        add_home = findViewById(R.id.add_home)
        add_reminder = findViewById(R.id.add_reminder)
        sub_home = findViewById(R.id.sub_home)
        sub_reminder = findViewById(R.id.sub_reminder)
        submit = findViewById(R.id.submit)
        delete = findViewById(R.id.delete)



        add_home.setOnClickListener{
            balance = amount_home
            balance.text = balance.toString()
            amount_home.text
        }
        submit.setOnClickListener {
            amount_reminder.setText("0")
        }


    }
}