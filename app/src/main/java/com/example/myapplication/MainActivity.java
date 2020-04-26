package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mail;
    private EditText pass;
    private Button btn;
    private Validator validator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        btn = findViewById(R.id.btn);
        validator = new Validator();
        mail.addTextChangedListener(validator);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Don't proceed if the fields do not validate.
                if (!validator.isValid()) {
                    mail.setError("Invalid email");
                    Toast toast=Toast.makeText(getApplicationContext(),"Invalid Email",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                String password = pass.getText().toString();

                // Don't proceed if the fields do not validate.
                if (validator.isValidPassword(password)) {
                    pass.setError("Invalid pass");
                    Toast toast=Toast.makeText(getApplicationContext(),"Invalid password",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                Toast toast=Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG);
                toast.show();

            }
        });

    }
}
