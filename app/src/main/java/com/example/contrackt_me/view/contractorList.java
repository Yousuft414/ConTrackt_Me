package com.example.contrackt_me.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.contrackt_me.R;
import com.example.contrackt_me.model.Contractor;
import com.example.contrackt_me.model.ContractorAdapter;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class contractorList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList <Contractor> contractorArrayList;
    ContractorAdapter contractorAdapter;
    FirebaseFirestore db;
    String city;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor_list);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            city = extras.getString("City");
            //The key argument here must match that used in the other activity
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();

        recyclerView = findViewById(R.id.contractors_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        contractorArrayList = new ArrayList<Contractor>();
        contractorAdapter = new ContractorAdapter(contractorList.this, contractorArrayList);

        recyclerView.setAdapter(contractorAdapter);

        FirebaseEvenChangeListener();
    }

    private void FirebaseEvenChangeListener() {

        db.collection("ContractorList")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if(error != null){
                            if(progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }
                            Log.e("Firestore error!", error.getMessage());
                            return;
                        }

                        for (DocumentChange documentChange : value.getDocumentChanges()){
                            if(documentChange.getType() == DocumentChange.Type.ADDED){
                                /*List<String> areas = documentChange.getDocument().toObject(Contractor.class).getAreasServed();
                                for (String cities: areas
                                     ) {
                                    if(cities == city){
                                        contractorArrayList.add(documentChange.getDocument().toObject(Contractor.class));
                                    }

                                }*/
                                contractorArrayList.add(documentChange.getDocument().toObject(Contractor.class));
                            }
                        }

                        contractorAdapter.notifyDataSetChanged();
                        if(progressDialog.isShowing()){
                            progressDialog.dismiss();
                        }

                    }
                });
    }
}