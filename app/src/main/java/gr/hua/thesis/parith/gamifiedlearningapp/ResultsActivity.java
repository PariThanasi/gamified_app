package gr.hua.thesis.parith.gamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Toolbar toolbar = findViewById(R.id.quizCategoriesToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Quiz Results");

    }
}
