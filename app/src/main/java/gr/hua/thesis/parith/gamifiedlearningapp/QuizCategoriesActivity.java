package gr.hua.thesis.parith.gamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import androidx.appcompat.widget.Toolbar;


public class QuizCategoriesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_categories);


       Toolbar toolbar = findViewById(R.id.quizCategoriesToolbar);
       setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Quiz Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //----------------------LISTENERS FOR THE KEY BUTTONS/ACTIVITIES -------------------------

        //Build the Listener for Button "Category 1"
        Button playButton = (Button) findViewById(R.id.btn_category1);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a intent to go to Quiz Categories Activity when we click the button "Let's play"
                startActivity(new Intent(QuizCategoriesActivity.this, QuizStructureActivity.class));
            }
        });


    }


}
