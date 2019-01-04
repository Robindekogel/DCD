package com.example.android.dcd_v31.Staff;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.dcd_v31.R;
import com.example.android.dcd_v31.StaffDetail.staffDetailActivity;
import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.ViewHolder>  {
    private Context context;
    private List<StaffMember> list;
    String id;


    public StaffAdapter(Context context, List<StaffMember> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final StaffMember staffList = list.get(position);
     holder.textfirstname.setText(staffList.getFirstname());
     holder.textinsertion.setText(staffList.getInsertion());
     holder.textlastname.setText(staffList.getLastname());
     holder.textemail.setText(staffList.getEmail());

     holder.textfirstname.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(context,staffDetailActivity.class);
             intent.putExtra("id",staffList.getId());
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
            textfirstname = itemView.findViewById(R.id.main_firstname);
            textinsertion = itemView.findViewById(R.id.main_insertion);
            textlastname = itemView.findViewById(R.id.main_lastname);
            textemail = itemView.findViewById(R.id.main_email);


                        }
                    }
                }




