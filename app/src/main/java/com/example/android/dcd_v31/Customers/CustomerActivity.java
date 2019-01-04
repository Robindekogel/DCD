package com.example.android.dcd_v31.Customers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.dcd_v31.HistoryActivity;
import com.example.android.dcd_v31.MainActivity;
import com.example.android.dcd_v31.R;
import com.example.android.dcd_v31.Staff.StaffActivity;
import com.example.android.dcd_v31.personalActivity;
import com.example.android.dcd_v31.taskActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private List<Customers> customerlist;
    private RecyclerView.Adapter adapter;
    private DividerItemDecoration dividerItemDecoration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mList = findViewById(R.id.customer_list);
        customerlist = new ArrayList<>();
        adapter = new CustomersAdapter(getApplicationContext(),customerlist);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(),linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);
        getCustomerData();
        getCustomerData();
        getCustomerData();
        getCustomerData();
    }
    Context mContext;
    private void getCustomerData() {
        String mJSONURLString = "http://dcdsysteem.devomgeving.nl/api/customers/";
        final String accessToken = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjcxYzFkYjljOWUxNDU2Zjk4ZDUwMzhkZWFlY2YzMDA5MGE5OGNjYmZiNTk4MjJiMDlhMDZmM2JjYTYxYTM1NGJlMzE5NTYzMzExMzE2NGFlIn0.eyJhdWQiOiIzIiwianRpIjoiNzFjMWRiOWM5ZTE0NTZmOThkNTAzOGRlYWVjZjMwMDkwYTk4Y2NiZmI1OTgyMmIwOWEwNmYzYmNhNjFhMzU0YmUzMTk1NjMzMTEzMTY0YWUiLCJpYXQiOjE1NDIxOTk2OTUsIm5iZiI6MTU0MjE5OTY5NSwiZXhwIjoxNTczNzM1Njk1LCJzdWIiOiIzIiwic2NvcGVzIjpbIioiXX0.wd4PmMbeXGorC-YujWTJkhVBHAzXW5LKfWrDLbryjTAkX9whUcd8e_uSCkUlD3YaGSzqGgKQBc8AFT2Z9Bg1LQEuuRl1mijYpZxmWZ3uKDRzaaGsxfKlEeHifXxaTeKI5hXqB_QjcowmV2NmlVXxR1WMdQlpsFTHDDzkar4PzgTSmaHvHe6NXjoSbmaVq3-T1jES9OJhr6ELHRtn1DUga1sIP614iPJKDtJH6K9FLUzcGL13-g8Z8JcWsq9_vAnyo3itL8MRl1RheQKNGIQ0sMmuiDmgxtKAnlWy9vNFu2bgmu0gtSce9QCDasRSgd8C_89_cIQPRV3rGyTzcDZD0sZ0egtPrzcQCka_5ZpD_rP7FlQVs-1SJGTLqm9RACZ07y2G09FaKmp3vDfHbo0fZNiwCg5wL2ARxaIGLweW0iAL-3mpuoonIFIblfGc4Mu14Y8MEsHZkBIE3Q45lwT0Bd-2NWKe_wCrVTiZ2ZIPnZ3YkiFxnW46sIswgSGB-cFTtu54v__XHN9YigVFBrGIA6Q83TsKHmPhV6LxwE3ia37_3aiI-aYsos6wFqiyC4rE-oHlEr_kUFJNl_Fz0EcxxOEeLz1y9gqcBk21urzAORiYrDHiBkotqHH0s0iZMtD10ooO3ct2SyTf3YLJDCazFuWSB-TLuF_6-vGxDhIW74E";

        // Initialize a new JsonArrayRequest instance
        StringRequest eventoReq3 = new StringRequest(
                Request.Method.GET,
                mJSONURLString,
                new Response.Listener<String>() {

                    public void onResponse(String response) {
                        // Process the JSON
                        JSONArray JA = null;
                        try {
                            JA = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < JA.length(); i++) {
                            JSONObject JO = null;
                            JSONObject JU = null;
                            try {
                                JO = (JSONObject) JA.get(i);
                                //JU = (JSONObject) JO.get("user_details");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                Customers customer = new Customers();
                                assert JO != null;
                                customer.setId(JO.getString("id"));
                                customer.setFirstname(JO.getString("firstname"));
                                customer.setInsertion(JO.getString("insertion"));
                                customer.setLastname(JO.getString("lastname"));
                                customer.setEmail(JO.getString("email"));

                                customerlist.add(customer);
                                adapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        String body;
                        //get status code here
                        String statusCode = String.valueOf(error.networkResponse.statusCode);
                        //get response body and parse with appropriate encoding
                        if (error.networkResponse.data != null) {
                            try {
                                body = new String(error.networkResponse.data, "UTF-8");
                                String e = "";
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                        String b = "";
                    }
                }) {
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", accessToken);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(eventoReq3);

    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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

//  @Override
//  public boolean onCreateOptionsMenu(Menu menu) {
//      getMenuInflater().inflate(R.menu.main, menu);
//      final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
//      SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
//      searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//      searchView.setSubmitButtonEnabled(true);
//      return true;
//  }

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
                Intent a1= new Intent(CustomerActivity.this,MainActivity.class);
                startActivity(a1);
                break;
            case R.id.nav_personal:
                Intent a2= new Intent(CustomerActivity.this,personalActivity.class);
                startActivity(a2);
                break;
            case R.id.nav_staff:
                Intent a8= new Intent(CustomerActivity.this,StaffActivity.class);
                startActivity(a8);
                break;
            case R.id.nav_action:
                Intent a3= new Intent(CustomerActivity.this,taskActivity.class);
                startActivity(a3);
                break;
            case R.id.nav_info:
                Intent a5= new Intent(CustomerActivity.this,MainActivity.class);
                startActivity(a5);
                break;
            case R.id.nav_search:
                Intent a6= new Intent(CustomerActivity.this,CustomerActivity.class);
                startActivity(a6);
                break;
            case R.id.nav_history:
                Intent a7= new Intent(CustomerActivity.this,HistoryActivity.class);
                startActivity(a7);
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
