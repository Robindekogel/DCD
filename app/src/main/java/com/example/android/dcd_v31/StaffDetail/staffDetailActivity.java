package com.example.android.dcd_v31.StaffDetail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.dcd_v31.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class staffDetailActivity extends AppCompatActivity {
    private RecyclerView dList;
    private List<emplyeeDetails> staffdetailList;
    private RecyclerView.Adapter adapter;
    private DividerItemDecoration dividerItemDecoration;
    private String id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_detail);
        dList = findViewById(R.id.staff_detail_list);

        staffdetailList = new ArrayList<emplyeeDetails>();
        adapter = new EmployeeAdapter(getApplicationContext(),staffdetailList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(dList.getContext(),linearLayoutManager.getOrientation());
        dList.setHasFixedSize(true);
        dList.setLayoutManager(linearLayoutManager);
        dList.addItemDecoration(dividerItemDecoration);
        dList.setAdapter(adapter);

        Intent i=getIntent();
        id =i .getStringExtra("id");
        getStaffData();
    }

    Context mContext;
    private void getStaffData() {
        String mJSONURLString = "http://dcdsysteem.devomgeving.nl/api/user/" + id + "/";
        final String accessToken = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjcxYzFkYjljOWUxNDU2Zjk4ZDUwMzhkZWFlY2YzMDA5MGE5OGNjYmZiNTk4MjJiMDlhMDZmM2JjYTYxYTM1NGJlMzE5NTYzMzExMzE2NGFlIn0.eyJhdWQiOiIzIiwianRpIjoiNzFjMWRiOWM5ZTE0NTZmOThkNTAzOGRlYWVjZjMwMDkwYTk4Y2NiZmI1OTgyMmIwOWEwNmYzYmNhNjFhMzU0YmUzMTk1NjMzMTEzMTY0YWUiLCJpYXQiOjE1NDIxOTk2OTUsIm5iZiI6MTU0MjE5OTY5NSwiZXhwIjoxNTczNzM1Njk1LCJzdWIiOiIzIiwic2NvcGVzIjpbIioiXX0.wd4PmMbeXGorC-YujWTJkhVBHAzXW5LKfWrDLbryjTAkX9whUcd8e_uSCkUlD3YaGSzqGgKQBc8AFT2Z9Bg1LQEuuRl1mijYpZxmWZ3uKDRzaaGsxfKlEeHifXxaTeKI5hXqB_QjcowmV2NmlVXxR1WMdQlpsFTHDDzkar4PzgTSmaHvHe6NXjoSbmaVq3-T1jES9OJhr6ELHRtn1DUga1sIP614iPJKDtJH6K9FLUzcGL13-g8Z8JcWsq9_vAnyo3itL8MRl1RheQKNGIQ0sMmuiDmgxtKAnlWy9vNFu2bgmu0gtSce9QCDasRSgd8C_89_cIQPRV3rGyTzcDZD0sZ0egtPrzcQCka_5ZpD_rP7FlQVs-1SJGTLqm9RACZ07y2G09FaKmp3vDfHbo0fZNiwCg5wL2ARxaIGLweW0iAL-3mpuoonIFIblfGc4Mu14Y8MEsHZkBIE3Q45lwT0Bd-2NWKe_wCrVTiZ2ZIPnZ3YkiFxnW46sIswgSGB-cFTtu54v__XHN9YigVFBrGIA6Q83TsKHmPhV6LxwE3ia37_3aiI-aYsos6wFqiyC4rE-oHlEr_kUFJNl_Fz0EcxxOEeLz1y9gqcBk21urzAORiYrDHiBkotqHH0s0iZMtD10ooO3ct2SyTf3YLJDCazFuWSB-TLuF_6-vGxDhIW74E";

        // Initialize a new JsonArrayRequest instance
        StringRequest eventoReq3 = new StringRequest(
                Request.Method.GET,
                mJSONURLString,
                new Response.Listener<String>() {

                    public void onResponse(String response) {

                        String s = response;

                        // Process the JSON
                        JSONObject employee = null;
                        try {
                            employee = new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        JSONArray customers = null;
                        JSONObject userDetails = null;
                        try {
                            customers = (JSONArray) employee.get("customers");
                            userDetails = (JSONObject) employee.get("user_details");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            emplyeeDetails emplyeeDetails = new emplyeeDetails();
                            assert userDetails != null;
                            emplyeeDetails.setFirstname(userDetails.getString("firstname"));
                            emplyeeDetails.setInsertion(userDetails.getString("insertion"));
                            emplyeeDetails.setLastname(userDetails.getString("lastname"));
                            emplyeeDetails.setEmail(userDetails.getString("email"));
                            emplyeeDetails.setPhonenumber(userDetails.getString("phonenumber"));
                            emplyeeDetails.setMobile(userDetails.getString("mobile"));
                            emplyeeDetails.setMobileprivate(userDetails.getString("mobile_private"));
                            emplyeeDetails.setStreet(userDetails.getString("street"));
                            emplyeeDetails.setStreetnumber(userDetails.getString("street_number"));
                            emplyeeDetails.setZipcode(userDetails.getString("zipcode"));
                            emplyeeDetails.setBirthday(userDetails.getString("birthday"));
                            emplyeeDetails.setCity(userDetails.getString("city"));
                            emplyeeDetails.setProvince(userDetails.getString("province"));
                            emplyeeDetails.setEfirstname(userDetails.getString("emergency_firstname"));
                            emplyeeDetails.setEinsertion(userDetails.getString("emergency_insertion"));
                            emplyeeDetails.setElastname(userDetails.getString("emergency_lastname"));
                            emplyeeDetails.setErelation(userDetails.getString("emergency_relation"));
                            emplyeeDetails.setEphonenumber(userDetails.getString("emergency_phone"));
                            emplyeeDetails.setEemail(userDetails.getString("emergency_email"));

                            staffdetailList.add(emplyeeDetails);
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
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
    }


