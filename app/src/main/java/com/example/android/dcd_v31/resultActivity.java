package com.example.android.dcd_v31;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.dcd_v31.Staff.StaffActivity;
import com.example.android.dcd_v31.fetchData.fetchData;

public class resultActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static TextView data;
    String dataParsed = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
     data = findViewById(R.id.dataTextView);
     data.setText(dataParsed);
     Context mContext = getApplicationContext();
     fetchData process = new fetchData(mContext);
     process.execute();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
            super.onBackPressed();
        }
    }
 //   @Override
 //       public boolean onCreateOptionsMenu(Menu menu) {
 //           getMenuInflater().inflate(R.menu.main, menu);
 //           final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
 //           SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
 //           searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
 //           searchView.setSubmitButtonEnabled(true);
 //           return true;
 //   }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    /*** onClickListener Menu items*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.nav_home:
                Intent a1= new Intent(resultActivity.this,MainActivity.class);
                startActivity(a1);
                break;
            case R.id.nav_personal:
                Intent a2= new Intent(resultActivity.this,personalActivity.class);
                startActivity(a2);
                break;
            case R.id.nav_action:
                Intent a3= new Intent(resultActivity.this,taskActivity.class);
                startActivity(a3);
                break;
            case R.id.nav_info:
                Intent a5= new Intent(resultActivity.this,personalActivity.class);
                startActivity(a5);
                break;
            case R.id.nav_search:
                Intent a6= new Intent(resultActivity.this,searchActivity.class);
                startActivity(a6);
                break;
            case R.id.nav_history:
                Intent a7= new Intent(resultActivity.this,HistoryActivity.class);
                startActivity(a7);
                break;
            case R.id.nav_staff:
                Intent a20= new Intent(resultActivity.this,StaffActivity.class);
                startActivity(a20);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
