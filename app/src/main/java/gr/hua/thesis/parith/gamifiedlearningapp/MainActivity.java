package gr.hua.thesis.parith.gamifiedlearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//https://guides.codepath.com/android/using-the-app-toolbar
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();


        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null

            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("World of Java");

            //Build the Listener for the menu asset (ic_menu).
            //https://stackoverflow.com/questions/43905011/position-a-menu-item-at-the-left-end-of-the-actionbar
            toolbar.setNavigationIcon(R.drawable.ic_menu);  //your icon
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                //Do whatever you want to do here
                    Toast.makeText(getApplicationContext(), "Menu: Under Construction!", Toast.LENGTH_SHORT).show();
                }
            });




        //----------------------LISTENERS FOR THE KEY BUTTONS/ACTIVITIES -------------------------

        //Build the Listener for Button "Let's play"
        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a intent to go to Quiz Categories Activity when we click the button "Let's play"
                startActivity(new Intent(MainActivity.this, QuizCategoriesActivity.class));
            }
        });



        /* --------- ACTIVITIES (..INTENTS) UNDER CONSTRUCTION --------------------------------------
        //Build the Listener for Button "Learn or cheat"
        Button leanButton = (Button) findViewById(R.id.learnButton);
        leanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a intent to go to Learn Activities when we click the button "Learn or cheat"
                startActivity(new Intent(MainActivity.this, Learn.class));
            }
        });

        //Build the Listener for Button "Leaderboard"
        Button leaderboardButton = (Button) findViewById(R.id.leaderboardButton);
        leaderboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a intent to go to Leaderboard Activity when we click the button "Leaderboard"
                startActivity(new Intent(MainActivity.this, Leaderboard.class));
            }
        });

        //Build the Listener for Button "Coffee Challenge"
        Button  challengeButton = (Button) findViewById(R.id.challengeButton);
        challengeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a intent to go to Coffee Challenge Activity when we click the button "Coffee Challenge"
                startActivity(new Intent(MainActivity.this, CoffeeChallenge.class));
            }
        }); */


    }


    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu. This process adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_info:
                Toast.makeText(getApplicationContext(), "Game Rules: Under Construction!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
                //Build the Listener for Toolbar navigation "Logout"
                findViewById(R.id.nav_logout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mAuth.signOut();
                        //make a intent to go to Register Activity when we click the button "Create new activity"
                        Intent intentLogout = new Intent(MainActivity.this, LoginActivity.class);
                        intentLogout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentLogout);
                    }
                });

                break;

            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }



}
