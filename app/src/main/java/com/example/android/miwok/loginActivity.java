package com.example.android.miwok;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {
    private EditText etEmail,etPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            startActivity(new Intent(loginActivity.this,Home_Activity.class));
            finish();
        }

        etEmail= (EditText) findViewById(R.id.idemail);
        etPassword=(EditText) findViewById(R.id.idpassword);
    }
    public void login(View view)
    {   final ProgressDialog progressDialog=new ProgressDialog(this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
        String email=etEmail.getText().toString();
        String password=etPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                               progressDialog.dismiss();
                                Toast.makeText(loginActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(loginActivity.this,Home_Activity.class));
                               finish();

                        } else {
                            // If sign in fails, display a message to the user.

                         progressDialog.dismiss();
                        Toast.makeText(loginActivity.this, "Authentication failed.\n"+task.getException().toString(),
                                                    Toast.LENGTH_SHORT).show();
                        }


                    }
                });

    }
    public void gotoSignup(View view)
    {
        startActivity(new Intent(loginActivity.this,SignupAcivity.class));
        finish();
    }
}
