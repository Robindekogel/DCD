package com.example.android.dcd_v31;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class HistoryActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            //super.onBackPressed();
        }
    }
    //   @Override
    //  public boolean onCreateOptionsMenu(Menu menu) {
    //      getMenuInflater().inflate(R.menu.main, menu);
    //      final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
    //      SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
    //      searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
    //      searchView.setSubmitButtonEnabled(true);
    //      return true;
    //
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.nav_home:
                Intent a1= new Intent(HistoryActivity.this,MainActivity.class);
                startActivity(a1);
                break;
            case R.id.nav_personal:
                Intent a2= new Intent(HistoryActivity.this,personalActivity.class);
                startActivity(a2);
                break;
            case R.id.nav_staff:
                Intent a8= new Intent(HistoryActivity.this,resultActivity.class);
                startActivity(a8);
                break;
            case R.id.nav_action:
                Intent a3= new Intent(HistoryActivity.this,taskActivity.class);
                startActivity(a3);
                break;
            case R.id.nav_info:
                Intent a5= new Intent(HistoryActivity.this,MainActivity.class);
                startActivity(a5);
                break;
            case R.id.nav_search:
                Intent a6= new Intent(HistoryActivity.this,searchActivity.class);
                startActivity(a6);
                break;
            case R.id.nav_history:
                Intent a7= new Intent(HistoryActivity.this,HistoryActivity.class);
                startActivity(a7);
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

