package gr.hua.thesis.parith.gamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuizStructureActivity extends AppCompatActivity {

    List<QuestionQuest1> questList1;
//    Cursor questList1;

    public int score = 0;

    QuestionQuest1 currentQuest1;
    Random randomQuest1 = new Random();

    TextView textQuestionQuest1;
    RadioGroup radioGroup;
    RadioButton radioButtonAQ1, radioButtonBQ1, radioButtonCQ1, radioButtonDQ1;
    TextView textViewTimerQuest1;
    Button nextButtonQuest1;

    //CountDownTimer myCountDownTimer;
    TextView questionNumber;
    ArrayList<Integer> list = new ArrayList<>();


    int questionIncrease;
    ProgressBar progressBar;
    int progress = 1;
    String tableName = "", categoryName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_structure);

        Toolbar toolbar = findViewById(R.id.quizCategoriesToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Play Quiz");


        //https://stackoverflow.com/questions/4233873/how-do-i-get-extra-data-from-intent-on-android
        //Intent intent = getIntent();
        // Bundle bundle = intent.getExtras();

        /*    if (bundle != null) {
            tableName = (String) bundle.get("table_name");
            categoryName = (String) bundle.get("level_name");
            Log.d("Table Name", tableName);
            Log.d("Level Name", categoryName);
        }*/


        // Here we have to initialize the Counter
        // final CounterClass timer = new CounterClass(1800000, 1000);
        // timer.start();

        //Initialize db instance
        DbHelper db = new DbHelper(this);

        //Initialize Timer and Question Numbers
        textViewTimerQuest1 = (TextView) findViewById(R.id.textViewTimer);
        questionNumber = (TextView)findViewById(R.id.correctlyAnsweredQuestions);

        //tableName = "category";
        //Get all questions at Quest 1, and put it at a List with name "questList1"
        questList1 = db.getAllQuestions( "A");
        for (int i = 0; i < 10; i++) {
            while (true) {
                //make it random and then add it to the list
                int next = randomQuest1.nextInt(10);
                if (!list.contains(next)) {
                    list.add(next);
                    break;
                }
            }
        }

        //Get the first entry of the created List and load it to currentQuest1
        currentQuest1 = questList1.get(list.get(0));
        //Initialize question Text. Here will be the description of the question
        textQuestionQuest1 = (TextView) findViewById(R.id.questionText);

        //Method who sets the View of Quiz Structure
        setQuizStructureView();

        //Initialize Radio Group. The state of "Next Button" initially it's false
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        nextButtonQuest1.setEnabled(false);
        //Initialize Radio Buttons that contained at Radio Group
        radioButtonAQ1 = (RadioButton) findViewById(R.id.radio1);
        radioButtonBQ1 = (RadioButton) findViewById(R.id.radio2);
        radioButtonCQ1 = (RadioButton) findViewById(R.id.radio3);
        radioButtonDQ1 = (RadioButton) findViewById(R.id.radio4);

        //Initialize "Next Button". This button directs us to the next question
        nextButtonQuest1 = (Button) findViewById(R.id.buttonNextQuestion);


        //When we set the Radio Group state then :
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //if we pressed a radio option :
                if (i == R.id.radio1 || i == R.id.radio2 || i == R.id.radio3 || i == R.id.radio4)
                    // then the "Next button" activated to direct us, to the next question
                    nextButtonQuest1.setEnabled(true);
            }
        });

        //Initialize Progress Bar (starts at 1 , ends at 10)
        progressBar = (ProgressBar) findViewById(R.id.quizProgressBar);
        progressBar.setMax(10);
        progressBar.setProgress(1);

        //When we push the "Next Button" then:
        nextButtonQuest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //the progress bar increases by 1
                progress = progress + 1;
                progressBar.setProgress(progress);

                //Check if radio button is checked. If is checked then we have to compare the answer:
                RadioButton answer = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                //if current question equals to identified answer
                if (currentQuest1.getANSWER().equals(answer.getText())) {
                    //then upgrade the score/points by 100
                    score = score + 100;
                }

                //if is not checked  then:
                radioGroup.clearCheck();
                //we can't go to the next question
                nextButtonQuest1.setEnabled(false);

                if (questionIncrease < 11) {
                    //Quiz have only 10 questions. When all questions are answered then the quiz terminate
                    if (questionIncrease == 10) {
                         //setting the text inside the "Next" button to "End Quiz". The quiz ended !
                        nextButtonQuest1.setText("End Quiz");
                    }

                    //Get the number of questionIncrease (it show where are we inside the quiz) for entry of the created List and load it to currentQuest1
                    currentQuest1 = questList1.get(list.get(questionIncrease));

                    //Method who updates the View of Quiz Structure
                    setQuizStructureView();

                    //The quiz have been finished, so the timer must be ended
               /* } else {
                    timer.onFinish();
                    timer.cancel();
                }*/
                }
            }
        });



         // CounterClass  extends CountDownTimer
        // https://stackoverflow.com/questions/38975286/how-to-make-countdown-timer-to-show-same-time-in-all-activities


        /*UNDER CONSTRUCTION --> USER HAVE TO SEE THE RESULTS

           showResults(){

        }*/

    }

    private void setQuizStructureView() {

        textQuestionQuest1.setText(currentQuest1.getQUESTION());
        radioButtonAQ1.setText(currentQuest1.getOPTIONA());
        radioButtonBQ1.setText(currentQuest1.getOPTIONB());
        radioButtonCQ1.setText(currentQuest1.getOPTIONC());
        radioButtonDQ1.setText(currentQuest1.getOPTIOND());

        if(questionIncrease<10) {
            questionNumber.setText("0" + questionIncrease + "/10");
        }else {
            questionNumber.setText("" + questionIncrease + "/10");
            questionIncrease++;
        }
    }

}
