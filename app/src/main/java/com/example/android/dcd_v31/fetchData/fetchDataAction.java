package com.example.android.dcd_v31.fetchData;

import android.os.AsyncTask;

import com.example.android.dcd_v31.resultActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchDataAction extends AsyncTask<Void,Void,Void> {
    String actionData ="";
    String dataParsed3 = "";
    String singleParsed3 ="";
    String line = "";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/p14ji");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                actionData = actionData + line;
            }

            JSONArray JA = new JSONArray(actionData);
            for(int i =0 ;i <JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed3 =  "Id: " + "\n" + JO.get("id") + "\n"+
                        "User id: "  + "\n" + JO.get("user_id") + "\n"+
                        "Id Klant: "  + "\n" + JO.get("customer_id") + "\n"+
                        "Categorie: " + "\n" + JO.get("action_category_id") + "\n"+
                        ""  + "\n" + JO.get("title") + "\n"+
                        "" + "\n" + JO.get("content") + "\n"+
                        "Prioriteit: " + "\n" + JO.get("priority") + "\n"+
                        "Afgerond: " + "\n" + JO.get("completed") + "\n"+
                        "Aangemaakt: " + "\n" + JO.get("created_at") + "\n"+
                        "Update: " + "\n" + JO.get("updated_at") + "\n";


                dataParsed3 = dataParsed3 + singleParsed3 +"\n" ;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        resultActivity.data.setText(this.dataParsed3);
    }

}