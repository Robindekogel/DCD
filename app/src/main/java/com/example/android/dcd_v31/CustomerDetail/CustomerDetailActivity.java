package com.example.android.dcd_v31.CustomerDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.dcd_v31.Customers.Customers;
import com.example.android.dcd_v31.HistoryActivity;
import com.example.android.dcd_v31.R;
import com.example.android.dcd_v31.Staff.StaffActivity;
import com.example.android.dcd_v31.personalActivity;
import com.example.android.dcd_v31.searchActivity;
import com.example.android.dcd_v31.taskActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDetailActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView cdList;
    private LinearLayoutManager linearLayoutManager;
    private List<CustomersDetail> customerDetaillist;
    private RecyclerView.Adapter adapter;
    private DividerItemDecoration dividerItemDecoration;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        cdList = findViewById(R.id.customer_list_detail);
        customerDetaillist = new ArrayList<CustomersDetail>();
        adapter = new CustomersDetailAdapter(getApplicationContext(),customerDetaillist);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(cdList.getContext(),linearLayoutManager.getOrientation());
        cdList.setHasFixedSize(true);
        cdList.setLayoutManager(linearLayoutManager);
        cdList.addItemDecoration(dividerItemDecoration);
        cdList.setAdapter(adapter);

            Intent i=getIntent();
            id =i .getStringExtra("id");
            getCustomerData();
        }
    Context mContext;
    private void getCustomerData() {
        String mJSONURLString = "http://dcdsysteem.devomgeving.nl/api/customer/"  + id + "/" ;
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
                                JSONObject JE = null;
                                JSONObject JB = null;
                                try {
                                    JO = (JSONObject) JA.get(i);
                                    JU = (JSONObject) JO.get("info");
                                    JE = (JSONObject) JO.get("payment_info");
                                    JB = (JSONObject) JO.get("business_info");

                             } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                             try {
                                    CustomersDetail customersDetail = new CustomersDetail();
                                    assert JU != null;
                                    customersDetail.setId(JO.getString("id"));
                                    customersDetail.setFirstname(JO.getString("firstname"));
                                    customersDetail.setInsertion(JO.getString("insertion"));
                                    customersDetail.setLastname(JO.getString("lastname"));
                                    customersDetail.setEmail(JO.getString("email"));
                                    customersDetail.setType(JO.getString("type"));
                                    //Info
                                    customersDetail.setId(JU.getString("customer_id"));
                                    customersDetail.setPhonenumber(JU.getString("phone"));
                                    customersDetail.setMobile(JU.getString("mobile"));
                                    customersDetail.setBirthdate(JU.getString("birthdate"));
                                    customersDetail.setStreet(JU.getString("street"));
                                    customersDetail.setStreetnumber(JU.getString("street_number"));
                                    customersDetail.setZipcode(JU.getString("zipcode"));
                                    customersDetail.setCity(JU.getString("city"));
                                    customersDetail.setExtrainfo(JU.getString("extra_info"));
                                    //Payment info
                                    customersDetail.setIBAN(JE.getString("IBAN"));
                                    customersDetail.setBIC(JE.getString("BIC"));
                                    customersDetail.setAccountnumber(JE.getString("account_number"));
                                    customersDetail.setAccountname(JE.getString("account_name"));
                                    customersDetail.setPaymentterm(JE.getString("payment_term"));
                                    customersDetail.setExtrainfo2(JE.getString("extra_info"));
                                    // business info
                                    customersDetail.setName(JB.getString("name"));
                                    customersDetail.setBusinessemail(JB.getString("email"));
                                    customersDetail.setBusinessphone(JB.getString("phone"));
                                    customersDetail.setKvk(JB.getString("KVK"));
                                    customersDetail.setBtw(JB.getString("BTW"));
                                    customersDetail.setWebsite(JB.getString("website"));
                                    customersDetail.setSize2(JB.getString("size"));
                                    customersDetail.setSector(JB.getString("sector"));
                                    customersDetail.setExtrainfo3(JB.getString("extra_info"));

                                    customerDetaillist.add(customersDetail);
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
                Intent a1= new Intent(CustomerDetailActivity.this,CustomerDetailActivity.class);
                startActivity(a1);
                break;
            case R.id.nav_personal:
                Intent a2= new Intent(CustomerDetailActivity.this,personalActivity.class);
                startActivity(a2);
                break;
            case R.id.nav_staff:
                Intent a8= new Intent(CustomerDetailActivity.this,StaffActivity.class);
                startActivity(a8);
                break;
            case R.id.nav_action:
                Intent a3= new Intent(CustomerDetailActivity.this,taskActivity.class);
                startActivity(a3);
                break;
            case R.id.nav_info:
                Intent a5= new Intent(CustomerDetailActivity.this,CustomerDetailActivity.class);
                startActivity(a5);
                break;
            case R.id.nav_search:
                Intent a6= new Intent(CustomerDetailActivity.this,searchActivity.class);
                startActivity(a6);
                break;
            case R.id.nav_history:
                Intent a7= new Intent(CustomerDetailActivity.this,HistoryActivity.class);
                startActivity(a7);
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
