package com.ali.anoweb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.StitchAppClient;
import com.mongodb.stitch.android.core.auth.StitchUser;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoCollection;
import com.mongodb.stitch.core.auth.providers.anonymous.AnonymousCredential;
import com.mongodb.stitch.core.services.mongodb.remote.RemoteUpdateOptions;
import com.mongodb.stitch.core.services.mongodb.remote.RemoteUpdateResult;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;

public class signuppage extends AppCompatActivity {
ImageView back;
Button signup;
App app;
EditText name,email,pass,conpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);



        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        conpass=findViewById(R.id.conpass);

        signup=findViewById(R.id.signup);

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signuppage.this,loginpagecustomer.class));
            }
        });

//        Realm.init(signuppage.this);
//        String appID ="application-0-crqjz";
//        app = new App(new AppConfiguration.Builder(appID)
//                .build());




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String nameString,emailString,passString;
nameString=name.getText().toString();
emailString=email.getText().toString();
passString=pass.getText().toString();
Intent intent=new Intent();
intent.putExtra("name",nameString);
intent.putExtra("email",emailString);
intent.putExtra("password",passString);
setResult(1,intent);
finish();

            }
        });




    }
}
