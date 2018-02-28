package com.example.justinsebastian.hora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ResultActivity extends AppCompatActivity {
    TextView textview;
  private   ListView listView;
    String sourcE;
    String desT;
    String timE;
    private DatabaseReference databaseReference;
    List<Details> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //marequee

        textview =(TextView) findViewById(R.id.text);
        textview.setSelected(true);

        listView = (ListView) findViewById( R.id.list1 );
        databaseReference = FirebaseDatabase.getInstance().getReference( "busdetail" );
        list = new ArrayList<>( );

        sourcE = getIntent().getStringExtra( "sourcee" );
        desT = getIntent().getStringExtra( "destinationn" );
        timE = getIntent().getStringExtra( "timee" );
        //Toast.makeText( this, "source is " + sourcE, Toast.LENGTH_SHORT ).show();

    }
    @Override
    protected void onStart(){
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot all_data : dataSnapshot.getChildren()) {
                    if(all_data!=null)
                        Toast.makeText(ResultActivity.this,"Searching..",Toast.LENGTH_SHORT).show();
                    Details details = all_data.getValue(Details.class);

                    if (details.getSource().equals( sourcE )){
                        if (details.getDestination().equals( desT )){

                            list.add(details);
                        }

                    }

                }
                DetailsAdapter detailsAdapter = new DetailsAdapter( ResultActivity.this, list);
                listView.setAdapter(detailsAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
