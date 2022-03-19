package com.example.icp8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                    if ((username.getText().toString().equals("sai")) && (password.getText().toString().equals("password@321"))) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Login is success!", Toast.LENGTH_SHORT).show();
                    } else { //incorrect username/password
                        if (!username.getText().toString().equals("sai")) {
                            Toast.makeText(MainActivity.this, "Username doesn't exist", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Password is not correct", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else { //missing details(username/password)
                    Toast.makeText(MainActivity.this, "Please enter username, password and click login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
