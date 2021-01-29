package gr.hua.thesis.parith.gamifiedlearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText inputEmail;
    private Button resetPasswordButton;
    private ProgressBar progressBar;

    //declare an instance of FirebaseAuthorization
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //Initialize variables
        inputEmail=(EditText)findViewById(R.id.editTextEmailFP) ;
        resetPasswordButton = (Button)findViewById(R.id.resetPasswordButton) ;
        progressBar = (ProgressBar)findViewById(R.id.progressBarFP);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //When you click button "Reset Password", call method resetPassword();
                resetPassword();

            }
        });


        //Build the Listener for "Back" to Login Activity
        findViewById(R.id.imageViewBackFP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a intent to go to Register Activity when we click the button "Create new activity"
                startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
            }
        });

    }

    private void resetPassword(){
        String email = inputEmail.getText().toString();
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

        progressBar.setVisibility(View.VISIBLE);

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPasswordActivity.this, "Check your e-mail ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    
                    progressBar.setVisibility(View.GONE);
                }else{
                    Toast.makeText(ForgotPasswordActivity.this, "Something going wrong. Please try again! ", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }

}
