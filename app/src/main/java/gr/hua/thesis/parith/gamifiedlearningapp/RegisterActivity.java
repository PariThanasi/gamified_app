package gr.hua.thesis.parith.gamifiedlearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {

    private EditText inputUsername, inputEmail, inputPassword;
    private ProgressBar registerProgressBar;
    private CheckBox termsCheckBox;

    //declare an instance of FirebaseAuthorization
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //Initialize textViews
        inputUsername = findViewById(R.id.editTextUsernameRegister);
        inputEmail = findViewById(R.id.editTextEmailRegister);
        inputPassword = findViewById(R.id.editTextPassRegister);
        termsCheckBox = findViewById(R.id.checkBoxTerms);

        //Initialize ProgressBar
        registerProgressBar = (ProgressBar)findViewById(R.id.progressBarRegister);


        //Build the Listener for "Register"
        Button RegisterButton = (Button) findViewById(R.id.registerButton);
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkRegisterInputs();

            }
        });


        //Build the Listener for "Sign in"
        findViewById(R.id.textViewAlreadyMemberSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a intent to go to Register Activity when we click the button "Create new activity"
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        //Build the Listener for "Back"
        findViewById(R.id.imageViewBackRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a intent to go to Register Activity when we click the button "Create new activity"
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }




    //Method to check inputs
    private void checkRegisterInputs() {


        //take the input values to Strings
        String username = inputUsername.getText().toString();
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        Boolean checkBox =termsCheckBox.isChecked();


        if(username.isEmpty()){
            inputUsername.setError("Username is required!");
            inputUsername.requestFocus();
            return;
        }
        if(username.length() < 6){
            inputUsername.setError("Minimum characters for username is 6");
            inputUsername.requestFocus();
            return;
        }
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
        if (checkBox == false){
            Toast.makeText(RegisterActivity.this, "You have to read and accept terms and conditions", Toast.LENGTH_SHORT).show();
        }
        registerProgressBar.setVisibility(View.VISIBLE);


            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Successfully registration!", Toast.LENGTH_SHORT).show();

                                Intent intentRegister = new Intent(RegisterActivity.this, LoginActivity.class);
                                intentRegister.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intentRegister);

                            } else {

                                Toast.makeText(RegisterActivity.this, "Fail registration! Try again! ", Toast.LENGTH_SHORT).show();
                                registerProgressBar.setVisibility(View.GONE);
                            }
                        }
                    });

        }

    }



   /* //https://stackoverflow.com/questions/2342620/how-to-hide-keyboard-after-typing-in-edittext-in-android
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }*/






