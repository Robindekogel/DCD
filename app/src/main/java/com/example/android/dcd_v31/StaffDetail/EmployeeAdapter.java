package com.example.android.dcd_v31.StaffDetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.dcd_v31.R;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private Context context;
    private List<emplyeeDetails> list;


    public EmployeeAdapter(Context context, List<emplyeeDetails> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item_detail, parent, false);
        return new ViewHolder(v);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        emplyeeDetails emplyeeDetails = list.get(position);
        holder.textfirstname.setText(String.valueOf(emplyeeDetails.getFirstname()));
      //  holder.textinsertion.setText(String.valueOf(emplyeeDetails.getInsertion()));
       // holder.textlastname.setText(String.valueOf(emplyeeDetails.getLastname()));
        holder.textemail.setText(String.valueOf(emplyeeDetails.getEmail()));
        holder.textphonenumber.setText(String.valueOf(emplyeeDetails.getPhonenumber()));
        holder.textmobile.setText(String.valueOf(emplyeeDetails.getMobile()));
        holder.textmobileprivate.setText(String.valueOf(emplyeeDetails.getMobileprivate()));
        holder.textstreet.setText(String.valueOf(emplyeeDetails.getStreet()));
        holder.textstreetnumber.setText(String.valueOf(emplyeeDetails.getStreetnumber()));
        holder.textzipcode.setText(String.valueOf(emplyeeDetails.getZipcode()));
        holder.textbirthday.setText(String.valueOf(emplyeeDetails.getBirthday()));
        holder.textcity.setText(String.valueOf(emplyeeDetails.getCity()));
        holder.textprovince.setText(String.valueOf(emplyeeDetails.getProvince()));
        holder.textEfirstname.setText(String.valueOf(emplyeeDetails.getEfirstname()));
        //holder.textEinsertion.setText(String.valueOf(emplyeeDetails.getEinsertion()));
        //holder.textElastname.setText(String.valueOf(emplyeeDetails.getElastname()));
        holder.textErelation.setText(String.valueOf(emplyeeDetails.getErelation()));
        holder.textEphonenumber.setText(String.valueOf(emplyeeDetails.getEphonenumber()));
        holder.textEemail.setText(String.valueOf(emplyeeDetails.getEemail()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView textfirstname, textinsertion, textlastname, textemail, textemailprivate, textphonenumber, textphonenumberprivate, textmobile, textmobileprivate, textstreet, textstreetnumber, textzipcode,
    textbirthday, textcity, textprovince, textEfirstname, textEinsertion, textElastname, textErelation, textEphonenumber, textEemail;

    public ViewHolder(View itemView) {
        super(itemView);

        textfirstname  = itemView.findViewById(R.id.main_firstname_Detail);
       //textinsertion = itemView.findViewById(R.id.main_insertion_Detail);
      // textlastname = itemView.findViewById(R.id.main_lastname_Detail);
        textemail = itemView.findViewById(R.id.main_email_Detail);
        textphonenumber = itemView.findViewById(R.id.main_phonenumber_Detail);
        textmobile = itemView.findViewById(R.id.main_mobile_Detail);
        textmobileprivate = itemView.findViewById(R.id.main_mobile_private_Detail);
        textstreet= itemView.findViewById(R.id.main_street_Detail);
        textstreetnumber= itemView.findViewById(R.id.main_streetnumber_Detail);
        textzipcode= itemView.findViewById(R.id.main_zipcode_Detail);
        textbirthday= itemView.findViewById(R.id.main_birthday_Detail);
        textcity = itemView.findViewById(R.id.main_city_Detail);
        textprovince = itemView.findViewById(R.id.main_province_Detail);
        textEfirstname = itemView.findViewById(R.id.main_emergency_firstname_Detail);
        //textEinsertion = itemView.findViewById(R.id.main_emergency_insertion_Detail);
       //textElastname = itemView.findViewById(R.id.main_emergency_lastname_Detail);
        textErelation = itemView.findViewById(R.id.main_emergency_relation_Detail);
        textEphonenumber = itemView.findViewById(R.id.main_emergency_phonenumber_Detail);
        textEemail = itemView.findViewById(R.id.main_emergency_email_Detail);

        }
    }
}