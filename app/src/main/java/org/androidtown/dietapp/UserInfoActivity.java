package org.androidtown.dietapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserInfoActivity extends AppCompatActivity {
    TextView textViewName;
    TextView textViewAge;
    TextView textViewWeight;
    TextView textViewBasicCalorie;
    TextView textViewGender;

    EditText editTextName;
    EditText editTextAge;
    EditText editTextWeight;
    EditText editTextBasicCalorie;
    EditText editTextGender;

    Button buttonSubmit;

    DatabaseReference mRoofRef;
    DatabaseReference mUserRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid=user.getUid();
        mRoofRef = FirebaseDatabase.getInstance().getReference();
        mUserRef=mRoofRef.child("user").child(uid);

        textViewName=(TextView)findViewById(R.id.textViewName);
        textViewAge=(TextView)findViewById(R.id.textViewAge);
        textViewWeight=(TextView)findViewById(R.id.textViewWeight);
        textViewBasicCalorie=(TextView)findViewById(R.id.textViewBasicCalorie);
        textViewGender=(TextView)findViewById(R.id.textViewGender);

        editTextName=(EditText) findViewById(R.id.editTextName);
        editTextAge=(EditText)findViewById(R.id.editTextAge);
        editTextWeight=(EditText)findViewById(R.id.editTextWeight);
        editTextBasicCalorie=(EditText)findViewById(R.id.editTextBasicCalorie);
        editTextGender=(EditText)findViewById(R.id.editTextGender);

        buttonSubmit=(Button)findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String email = user.getEmail();
                String name = editTextName.getText().toString();
                int age = Integer.parseInt(editTextAge.getText().toString());
                int weight = Integer.parseInt(editTextWeight.getText().toString());
                int basicCalorie = Integer.parseInt(editTextBasicCalorie.getText().toString());
                String gender = editTextGender.getText().toString();
                mUserRef.setValue(new UsersItem(email, uid, name, age, weight, basicCalorie, gender));
            }
        });

    }
}
