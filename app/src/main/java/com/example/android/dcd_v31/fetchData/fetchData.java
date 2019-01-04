package com.example.android.dcd_v31.fetchData;

import android.content.Context;
import android.os.AsyncTask;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.HashMap;

public class fetchData extends AsyncTask<Void, Void, Boolean> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    String line = "";
    Context mContext;

    public fetchData(Context mContext) {
        this.mContext = mContext;
    }
    @Override
    public Boolean doInBackground(Void... voids) {

        String mJSONURLString = "http://dcdsysteem.devomgeving.nl/api/users";
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        final String accessToken = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjcxYzFkYjljOWUxNDU2Zjk4ZDUwMzhkZWFlY2YzMDA5MGE5OGNjYmZiNTk4MjJiMDlhMDZmM2JjYTYxYTM1NGJlMzE5NTYzMzExMzE2NGFlIn0.eyJhdWQiOiIzIiwianRpIjoiNzFjMWRiOWM5ZTE0NTZmOThkNTAzOGRlYWVjZjMwMDkwYTk4Y2NiZmI1OTgyMmIwOWEwNmYzYmNhNjFhMzU0YmUzMTk1NjMzMTEzMTY0YWUiLCJpYXQiOjE1NDIxOTk2OTUsIm5iZiI6MTU0MjE5OTY5NSwiZXhwIjoxNTczNzM1Njk1LCJzdWIiOiIzIiwic2NvcGVzIjpbIioiXX0.wd4PmMbeXGorC-YujWTJkhVBHAzXW5LKfWrDLbryjTAkX9whUcd8e_uSCkUlD3YaGSzqGgKQBc8AFT2Z9Bg1LQEuuRl1mijYpZxmWZ3uKDRzaaGsxfKlEeHifXxaTeKI5hXqB_QjcowmV2NmlVXxR1WMdQlpsFTHDDzkar4PzgTSmaHvHe6NXjoSbmaVq3-T1jES9OJhr6ELHRtn1DUga1sIP614iPJKDtJH6K9FLUzcGL13-g8Z8JcWsq9_vAnyo3itL8MRl1RheQKNGIQ0sMmuiDmgxtKAnlWy9vNFu2bgmu0gtSce9QCDasRSgd8C_89_cIQPRV3rGyTzcDZD0sZ0egtPrzcQCka_5ZpD_rP7FlQVs-1SJGTLqm9RACZ07y2G09FaKmp3vDfHbo0fZNiwCg5wL2ARxaIGLweW0iAL-3mpuoonIFIblfGc4Mu14Y8MEsHZkBIE3Q45lwT0Bd-2NWKe_wCrVTiZ2ZIPnZ3YkiFxnW46sIswgSGB-cFTtu54v__XHN9YigVFBrGIA6Q83TsKHmPhV6LxwE3ia37_3aiI-aYsos6wFqiyC4rE-oHlEr_kUFJNl_Fz0EcxxOEeLz1y9gqcBk21urzAORiYrDHiBkotqHH0s0iZMtD10ooO3ct2SyTf3YLJDCazFuWSB-TLuF_6-vGxDhIW74E";

        StringRequest eventoReq3 = new StringRequest(
                Request.Method.GET,
                mJSONURLString,
                new Response.Listener<String>() {
                    private String dataParsed = "";
                    public void onResponse(String response) {

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
                                    singleParsed =  "" +  JU.get("firstname") + " " +
                                                    "" + JU.get("insertion") + " " +
                                                    " " + JU.get("lastname") + "\n"+
                                                    "" + JU.get("email") + "\n";

                                    this.dataParsed = this.dataParsed + singleParsed + "\n";

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            String a = response;
                            //resultActivity.data.setText(this.dataParsed);

                        }
                },
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        String body;

                        String statusCode = String.valueOf(error.networkResponse.statusCode);

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
        requestQueue.add(eventoReq3);
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aVoid) {
        super.onPostExecute(aVoid);
        //resultActivity.data.setText(this.dataParsed);
    }
}

