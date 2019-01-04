package com.example.android.dcd_v31.fetchData;

import android.os.AsyncTask;
import com.example.android.dcd_v31.personalActivity;
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

public class fetchDataPersonal extends AsyncTask<Void,Void,Void> {
    String personalData ="";
    String dataParsed2 = "";
    String singleParsed2 ="";
    String line2 = "";
    @Override
    protected Void doInBackground(Void... voids) {


        try {
            URL url = new URL("https://api.myjson.com/bins/14unh2");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line2 = "";
            while(line2 != null){
                line2 = bufferedReader.readLine();
                personalData = personalData + line2;
            }

            JSONArray JA = new JSONArray(personalData);
            for(int i =0 ;i <JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed2 =
                        "id: " + "\n" + JO.get("id") + "\n"+
                        "Voornaam: " + "\n" + JO.get("firstname") + "\n"+
                        "Tussenvoegsel: "  + "\n" + JO.get("insertion") + "\n"+
                        "Achternaam: "  + "\n" + JO.get("lastname") + "\n"+
                        "E mail: " + "\n" + JO.get("email") + "\n"+
                        "Prive mail: " + "\n" + JO.get("email_private") + "\n"+
                        "Telefoon: " + "\n" + JO.get("phonenumber") + "\n" +
                        "Mobiel: " + "\n" + JO.get("mobile") + "\n"+
                        "Prive Mobiel: " + "\n" + JO.get("mobile_private") + "\n"+
                        "Geboortedatum: " + "\n" + JO.get("birthday") + "\n"+
                        "Adres: " + "\n" + JO.get("street") + "\n"+
                        "Huisnummer: " + "\n" + JO.get("street_number") + "\n"+
                        "postcode:" + "\n" + JO.get("zipcode") + "\n"+
                        "Stad: " + "\n" + JO.get("city") + "\n"+
                        "Provincie: " + "\n" + JO.get("province") + "\n\n"+
                        "Noodgegevens" + "\n"+
                        "Voornaam: " + "\n" + JO.get("emergency_firstname") + "\n"+
                        "Tussenvoegsel: " + "\n" + JO.get("emergency_insertion") + "\n"+
                        "Achternaam: " + "\n" + JO.get("emergency_lastname") + "\n"+
                        "Relatie: "  + "\n" + JO.get("emergency_relation") + "\n"+
                        "Telefoon: "  + "\n" + JO.get("emergency_phone") + "\n"+
                        "E mail: "  + "\n" + JO.get("emergency_email") + "\n\n"+
                        "Aangemaakt: "  + "\n" + JO.get("created_at") + "\n"+
                        "Updated: "  + "\n" + JO.get("updated_at") + "\n";

                dataParsed2 = dataParsed2 + singleParsed2 +"\n" ;
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        personalActivity.personalData.setText(this.dataParsed2);
    }

}

