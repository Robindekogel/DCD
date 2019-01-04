package com.example.android.dcd_v31.Staff;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.dcd_v31.R;
import com.example.android.dcd_v31.Staff.StaffAdapter;
import com.example.android.dcd_v31.Staff.StaffMember;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class StaffActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private List <StaffMember> staffList;
    private RecyclerView.Adapter adapter;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_list);

        //Set de lijst - uitvoer Staffmemmbers
        mList = findViewById(R.id.staff_list);
        staffList = new ArrayList<>();
        adapter = new StaffAdapter(getApplicationContext(),staffList);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(),linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);
        getStaffData();
        getStaffData();
        getStaffData();


    }

    Context mContext;
    private void getStaffData() {
        String mJSONURLString = "http://dcdsysteem.devomgeving.nl/api/users";
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
                                JU = (JSONObject) JO.get("user_details");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                StaffMember staffMember = new StaffMember();
                                assert JU != null;
                                staffMember.setId(JU.getString("id"));
                                staffMember.setFirstname(JU.getString("firstname"));
                                staffMember.setInsertion(JU.getString("insertion"));
                                staffMember.setLastname(JU.getString("lastname"));
                                staffMember.setEmail(JU.getString("email"));

                                staffList.add(staffMember);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}


