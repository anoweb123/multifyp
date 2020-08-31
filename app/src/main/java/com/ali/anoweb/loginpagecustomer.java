package com.ali.anoweb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.ClientSessionOptions;

import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.ClientSession;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;

public class loginpagecustomer extends AppCompatActivity {
TextView signup;
Button login;
App app;
//   MongoClientURI uri;
EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpagecustomer);

        signup=findViewById(R.id.signup);
        login=findViewById(R.id.login);

        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);

//        Realm.init(this);
//        String appID ="application-0-crqjz";
//        app = new App(new AppConfiguration.Builder(appID)
//                .build());

//
//        MongoClientURI uri = new MongoClientURI(
//                "mongodb+srv://web:<password>@cluster0.ss9qt.mongodb.net/<dbname>?retryWrites=true&w=majority");
//        MongoClient mongoClient = new MongoClient(uri);
//        MongoDatabase database = mongoClient.getDatabase("test");

//        app.getEmailPasswordAuth().registerUserAsync("haiderzafar055@gmail.com", "hhhhhh", new App.Callback<Void>() {
//            @Override
//            public void onResult(App.Result<Void> it) {
//                if (it.isSuccess()) {
//                    Toast.makeText(loginpagecustomer.this, "Successfully registered user.", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(loginpagecustomer.this,it.getError().toString(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginpagecustomer.this,signuppage.class);
                startActivityForResult(intent,1);
            }


        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//        Credentials emailPasswordCredentials = Credentials.emailPassword(email.getText().toString(), pass.getText().toString());

//
//                app.loginAsync(emailPasswordCredentials, new App.Callback<User>() {
//            @Override
//            public void onResult(App.Result<User> it) {
//                if (it.isSuccess()) {
//                    Intent intent=new Intent(loginpagecustomer.this,dashboardcustomer.class);
//                    startActivity(intent);
//                }
//                else {
//                    Toast.makeText(loginpagecustomer.this, it.getError().toString(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
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