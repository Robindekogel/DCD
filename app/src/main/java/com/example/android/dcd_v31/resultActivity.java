package com.example.android.dcd_v31;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class resultActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        /*** onClickListener Google Maps*/
        Button button = (Button) findViewById(R.id.gmapsButtonView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=Randstad 22171, 1316 BM Almere"));
                startActivity(intent);
            }
        });
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
    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main, menu);
            final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
            SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setSubmitButtonEnabled(true);
            return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    /*** onClickListener textView open Mail application*/
    public void clickMail(View v) {
        switch(v.getId()) {
            case R.id.emailView:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:kevin@decomputerdienst.nl?subject=TEST");
                intent.setData(data);
                startActivity(intent);
        }
    }
    /*** onClickListener textView open Mail application*/
    public void clickMail2(View v) {
        switch(v.getId()) {
            case R.id.businessMailView2:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:info@decomputerdienst.nl?subject=TEST");
                intent.setData(data);
                startActivity(intent);
        }
    }
    /*** onClickListener textView open phoneDailer application*/
    public void clickPhone(View v) {
        switch(v.getId()) {
            case R.id.phoneView:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:036 5364154" + ""));
                startActivity(intent);
        }
    }
    /*** onClickListener textView open phoneDailer application*/
    public void clickPhone2(View v) {
        switch(v.getId()) {
            case R.id.mobilePhoneView:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0637313036" + ""));
                startActivity(intent);
        }
    }
    /*** onClickListener textView open phoneDailer application*/
    public void clickPhone3(View v) {
        switch(v.getId()) {
            case R.id.businessPhoneView2:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0637313036" + ""));
                startActivity(intent);
        }
    }
    /*** onClickListener textView open webbrowser application*/
    public void clickWebsite(View v) {
        switch(v.getId()) {
            case R.id.businessSiteView2:
                Uri uri = Uri.parse("http://decomputerdienst.nl");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
        }
    }
    /*** onClickListener Menu items*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.nav_home:
                Intent z= new Intent(resultActivity.this,MainActivity.class);
                startActivity(z);
                break;
            case R.id.nav_personal:
                Intent h= new Intent(resultActivity.this,personalActivity.class);
                startActivity(h);
                break;
            case R.id.nav_action:
                Intent x= new Intent(resultActivity.this,taskActivity.class);
                startActivity(x);
                break;
            case R.id.nav_log_out:
                Intent i= new Intent(resultActivity.this,LoginActivity.class);
                startActivity(i);
                break;
            case R.id.nav_info:
                Intent c= new Intent(resultActivity.this,personalActivity.class);
                startActivity(c);
                break;
            case R.id.nav_search:
                Intent v= new Intent(resultActivity.this,searchActivity.class);
                startActivity(v);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
