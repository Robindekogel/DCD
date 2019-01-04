package com.example.android.dcd_v31.Customers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.dcd_v31.CustomerDetail.CustomerDetailActivity;
import com.example.android.dcd_v31.R;
import java.util.List;

public class CustomersAdapter extends RecyclerView.Adapter<CustomersAdapter.ViewHolder>{

    private Context context;
    private List<Customers> list;
    String id;

    public CustomersAdapter(Context context, List<Customers> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item_customer, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Customers customerlist = list.get(position);
        holder.textfirstname.setText(customerlist.getFirstname());
        holder.textinsertion.setText(customerlist.getInsertion());
        holder.textlastname.setText(customerlist.getLastname());
        holder.textemail.setText(customerlist.getEmail());
        holder.textfirstname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CustomerDetailActivity.class);
                intent.putExtra("id",customerlist.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textfirstname, textinsertion, textlastname, textemail, txtid;

        public ViewHolder(View itemView) {
            super(itemView);
            textfirstname = itemView.findViewById(R.id.main_firstname_customer);
            textinsertion = itemView.findViewById(R.id.main_insertion_customer);
            textlastname = itemView.findViewById(R.id.main_lastname_customer);
            textemail = itemView.findViewById(R.id.main_email_customer);

        }
    }
}

