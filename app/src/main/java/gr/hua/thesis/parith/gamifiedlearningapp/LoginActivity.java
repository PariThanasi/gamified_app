package gr.hua.thesis.parith.gamifiedlearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {


    EditText inputEmail, inputPassword;
    private ProgressBar loginProgressBar;


    //declare an instance of FirebaseAuthorization
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //Method to see if user is already sign in.

        if (mAuth.getCurrentUser() !=null) {
            // Check if user is signed in (non-null) and update UI accordingly.
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        //Initialize textViews
        inputEmail = findViewById(R.id.editTextEmailSignIn);
        inputPassword = findViewById(R.id.editTextPassSignIn);

        loginProgressBar = (ProgressBar)findViewById(R.id.loginProgressBar);



        //Build the Listener for "Sign in"
        Button SignInButton = (Button) findViewById(R.id.signInButton);
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We have to check the inputs before Sign in. So this method checks users inputs when user click the Button Sign in
                checkLoginInputs();
            }
        });


        //Build the Listener for "Create new account"
        Button CreateAccountButton = (Button) findViewById(R.id.createAccountButton);
        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a intent to go to Register Activity when we click the button "Create new activity"
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });


         //Build the Listener for "Forgot Password"
         findViewById(R.id.textViewForgotPassword).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
          //make a intent to go to Register Activity when we click the button "Create new activity"
          startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
           }
        });


    }


        //Method to check inputs
        private void checkLoginInputs () {

            //take the input values to Strings
            String email = inputEmail.getText().toString();
            String password = inputPassword.getText().toString();


            if(email.isEmpty()){
                inputEmail.setError("Email is required!");
                inputEmail.requestFocus();
                return;
            }
            if( !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                inputEmail.setError("Not valid email");
                inputEmail.requestFocus();
                return;
            }
            if(password.isEmpty()){
                inputPassword.setError("Password is required!");
                inputPassword.requestFocus();
                return;
            }
            if(password.length() < 7){
                inputPassword.setError("Minimum characters for password is 7");
                inputPassword.requestFocus();
                return;
            }
            else
                loginProgressBar.setVisibility(View.VISIBLE);

                  mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("INFO", "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Authentication failed. Please try again", Toast.LENGTH_SHORT).show();
                                loginProgressBar.setVisibility(View.GONE);
                            }

                        }
                    });

    }

}