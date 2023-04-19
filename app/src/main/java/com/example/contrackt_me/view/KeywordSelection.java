package com.example.contrackt_me.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.contrackt_me.R;
import com.example.contrackt_me.model.Contractor;
import com.example.contrackt_me.model.Keywords;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class KeywordSelection extends AppCompatActivity {

    List<String> keywordList;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyword_selection);
        //keywordList = new ArrayList<String>();

        db = FirebaseFirestore.getInstance();
        
        FirebaseKeywordGetter();

    }

    private void FirebaseKeywordGetter() {
        db.collection("KeywordList").document("h7HT4YUHWDGyDc70giDM").addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error != null){

                    Log.e("Firestore error!", error.getMessage());
                    return;
                }

                keywordList = (List<String>) value.get("Keywords");
                System.out.println(keywordList);
            }
        });
    }


}