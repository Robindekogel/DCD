package com.example.android.dcd_v31.CustomerDetail;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.dcd_v31.Customers.Customers;
import com.example.android.dcd_v31.R;
import java.util.List;

public class CustomersDetailAdapter extends RecyclerView.Adapter<CustomersDetailAdapter.ViewHolder>{

    private Context context;
    private List<CustomersDetail> list;
    String id;

    public CustomersDetailAdapter(Context context, List<CustomersDetail> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item_customer_detail, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CustomersDetail customersDetail = list.get(position);
        holder.textfirstname.setText(customersDetail.getFirstname());
        holder.textinsertion.setText(customersDetail.getInsertion());
        holder.textlastname.setText(customersDetail.getLastname());
        holder.textemail.setText(customersDetail.getEmail());
        holder.txttype.setText(customersDetail.getType());
        holder.txtcustomerid.setText(customersDetail.getId());
        holder.txtphone.setText(customersDetail.getPhonenumber());
        holder.txtmobile.setText(customersDetail.getMobile());
        holder.txtbirthdate.setText(customersDetail.getBirthdate());
        holder.txtstreet.setText(customersDetail.getStreet());
        holder.txtstreetnumber.setText(customersDetail.getStreetnumber());
        holder.txtzipcode.setText(customersDetail.getZipcode());
        holder.txtcity.setText(customersDetail.getCity());
        holder.txtextrainfo1.setText(customersDetail.getExtrainfo());
        holder.txtiban.setText(customersDetail.getIBAN());
        holder.txtbic.setText(customersDetail.getBIC());
        holder.txtaccountnumber.setText(customersDetail.getAccountnumber());
        holder.txtaccountname.setText(customersDetail.getAccountname());
        holder.txtpaymentterm.setText(customersDetail.getPaymentterm());
        holder.txtextrainfo2.setText(customersDetail.getExtrainfo2());
        holder.txtname.setText(customersDetail.getName());
        holder.txtbusinessemail.setText(customersDetail.getBusinessemail());
        holder.txtbusinessphone.setText(customersDetail.getBusinessphone());
        holder.txtkvk.setText(customersDetail.getKvk());
        holder.txtbtw.setText(customersDetail.getBtw());
        holder.txtwebsite.setText(customersDetail.getWebsite());
        holder.txtsize.setText(customersDetail.getSize2());
        holder.txtsector.setText(customersDetail.getSector());
        holder.txtextrainfo3.setText(customersDetail.getExtrainfo3());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textfirstname, textinsertion, textlastname, textemail, txtid,txttype, txtcustomerid, txtphone, txtmobile, txtbirthdate, txtstreet,txtstreetnumber, txtzipcode, txtcity, txtextrainfo1, txtiban, txtbic, txtaccountnumber,txtaccountname,txtpaymentterm,txtextrainfo2,txtname,txtbusinessemail,txtbusinessphone,txtkvk,txtbtw,txtwebsite,txtsize,txtsector,txtextrainfo3;

        public ViewHolder(View itemView) {
            super(itemView);
            textfirstname = itemView.findViewById(R.id.main_firstname_customer_detail);
            textinsertion = itemView.findViewById(R.id.main_insertion_customer_detail);
            textlastname = itemView.findViewById(R.id.main_lastname_customer_detail);
            textemail = itemView.findViewById(R.id.main_email_customer_detail);
            txttype = itemView.findViewById(R.id.main_type_customer_detail);
            txtcustomerid = itemView.findViewById(R.id.main_type_customerid_detail);
            txtphone = itemView.findViewById(R.id.main_type_customerphone_detail);
            txtmobile = itemView.findViewById(R.id.main_type_customermobile_detail);
            txtbirthdate = itemView.findViewById(R.id.main_type_customerbirthdate_detail);
            txtstreet = itemView.findViewById(R.id.main_type_customerstreet_detail);
            txtstreetnumber = itemView.findViewById(R.id.main_type_customerstreetnumber_detail);
            txtzipcode = itemView.findViewById(R.id.main_type_customerzipcode_detail);
            txtcity = itemView.findViewById(R.id.main_type_customercity_detail);
            txtextrainfo1 = itemView.findViewById(R.id.main_type_customer_extrainfo_1_detail);
            txtiban = itemView.findViewById(R.id.main_type_customeriban_detail);
            txtbic = itemView.findViewById(R.id.main_type_customerbic_detail);
            txtaccountnumber = itemView.findViewById(R.id.main_type_customer_acountnumber_detail);
            txtaccountname = itemView.findViewById(R.id.main_type_customer_accountname_detail);
            txtpaymentterm = itemView.findViewById(R.id.main_type_customer_paymentterm_detail);
            txtextrainfo2 = itemView.findViewById(R.id.main_type_customer_extrainfo_2_detail);
            txtname = itemView.findViewById(R.id.main_type_customername_detail);
            txtbusinessemail = itemView.findViewById(R.id.main_type_customeremail_detail);
            txtbusinessphone = itemView.findViewById(R.id.main_type_customer_busisnessphone_detail);
            txtkvk = itemView.findViewById(R.id.main_type_customer_kvk_detail);
            txtbtw = itemView.findViewById(R.id.main_type_customer_BTW_detail);
            txtwebsite = itemView.findViewById(R.id.main_type_customer_website_detail);
            txtsize = itemView.findViewById(R.id.main_type_customer_size_detail);
            txtsector = itemView.findViewById(R.id.main_type_customer_sector_detail);
            txtextrainfo3 = itemView.findViewById(R.id.main_type_customer_extrainfo_3_detail);

        }
    }
}

