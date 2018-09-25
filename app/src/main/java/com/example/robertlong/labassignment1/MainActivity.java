package com.example.robertlong.labassignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;


public class MainActivity extends AppCompatActivity {
    //EditText fname;
    EditText lname, email;
    Button submit;
    AwesomeValidation awesomeValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        setContentView(R.layout.activity_main);

        updateUI();
    }

    private void updateUI() {
       // fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        email = (EditText) findViewById(R.id.email);
        submit = (Button) findViewById(R.id.submit);


        //awesomeValidation.addValidation(MainActivity.this, R.id.fname, "[a-zA-Z\\s]+", R.string.fnameerr);
        awesomeValidation.addValidation(MainActivity.this, R.id.lname, "[a-zA-Z\\s]+", R.string.lnameerr);
        awesomeValidation.addValidation(MainActivity.this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.emailerr);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //intent.putExtra("First name", fname.getText().toString());
                intent.putExtra("Last name", lname.getText().toString());
                intent.putExtra("Email", email.getText().toString());
                startActivity(intent);


//                if (awesomeValidation.validate()) {
//                    Toast.makeText(MainActivity.this, "Data Received Successfully", Toast.LENGTH_SHORT).show();
//                } else
//
//                {
//                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                }


            }
        });
    }
}

//    public void sendMessage(View v) {
//
//        Toast.makeText(this, "CHECK", Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(this, MainActivity2.class);
//        EditText fname = (EditText) findViewById(R.id.fname);
//        EditText lname = (EditText) findViewById(R.id.lname);
//        EditText email = (EditText) findViewById(R.id.email);
//        String message = fname.getText().toString();
//       // String message = lname.getText().toString();
//        //String message = email.getText().toString();
//        intent.putExtra("XYZ", message);
//        startActivity(intent);
//    }
//}
