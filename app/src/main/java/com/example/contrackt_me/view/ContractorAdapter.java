package com.example.contrackt_me.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contrackt_me.R;

import java.util.ArrayList;

public class ContractorAdapter extends RecyclerView.Adapter<ContractorAdapter.MyViewHolder> {

    Context context;
    ArrayList<Contractor> contractorArrayList;

    public ContractorAdapter(Context context, ArrayList<Contractor> contractorArrayList) {
        this.context = context;
        this.contractorArrayList = contractorArrayList;
    }

    @NonNull
    @Override
    public ContractorAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_contractor, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContractorAdapter.MyViewHolder holder, int position) {

        Contractor contractor = contractorArrayList.get(position);

        holder.Name.setText(contractor.Name);
        holder.Email.setText(contractor.Email);
        holder.Quote.setText(contractor.Quote);

    }

    @Override
    public int getItemCount() {
        return contractorArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Name, Email, Quote;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.contractor_name);
            Email = itemView.findViewById(R.id.contractor_email);
            Quote = itemView.findViewById(R.id.contractor_Quote);
        }
    }
}
