package com.ali.anoweb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;

public class loginpagecustomer extends AppCompatActivity {
TextView signup,forget;
Button login;
App app;
//   MongoClientURI uri;
EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpagecustomer);



        Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));



        signup=findViewById(R.id.signup);
        login=findViewById(R.id.login);
        forget=findViewById(R.id.forget);



        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginpagecustomer.this,forgetpassword.class);
                startActivity(intent);

            }


        });



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginpagecustomer.this,signuppage.class);
                startActivity(intent);

            }


        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(loginpagecustomer.this,dashboardcustomer.class);
                    startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1)
        {

            String name = data.getStringExtra("name");
            String email = data.getStringExtra("email");
            String password = data.getStringExtra("password");

            app.getEmailPasswordAuth().registerUserAsync(email, password, new App.Callback<Void>() {
                @Override
                public void onResult(App.Result<Void> it) {
                    if (it.isSuccess()) {
                        Toast.makeText(loginpagecustomer.this, "Email sent", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(loginpagecustomer.this, it.getError().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            app.getEmailPasswordAuth().confirmUserAsync("haiderzafar055@gmail.com", "5f43c0dcd1f4112edeca7463", new App.Callback<Void>() {
                @Override
                public void onResult(App.Result<Void> it) {
                    if (it.isSuccess()) {
                        Toast.makeText(loginpagecustomer.this, "", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(loginpagecustomer.this, it.getError().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });



        }
    }
}