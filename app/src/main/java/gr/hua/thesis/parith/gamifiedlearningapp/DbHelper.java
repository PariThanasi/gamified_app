package gr.hua.thesis.parith.gamifiedlearningapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

   private static final String DATABASE_NAME= "WorldOfJavaQuiz.db";
    private static final int DATABASE_VERSION = 1;
    //private static final String TABLE_QUEST1 = "questJavaIntroduction";
    private static final String KEY_ID = "id";
    private static final String KEY_CATEGORY= "category"; //category
    private static final String KEY_QUESTION = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTIONA= "optionA"; //option a
    private static final String KEY_OPTIONB= "optionB"; //option b
    private static final String KEY_OPTIONC= "optionC"; //option c
    private static final String KEY_OPTIOND= "optionD"; //option d

    private static final String SQL_CREATE_QUERY = "CREATE TABLE "+DATABASE_NAME+" ("+
            KEY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_QUESTION+" TEXT, "+
            KEY_OPTIONA+" TEXT, "+
            KEY_OPTIONB+" TEXT, "+
            KEY_OPTIONC+" TEXT, "+
            KEY_OPTIOND+" TEXT, "+
            KEY_ANSWER+" TEXT, "+
            KEY_CATEGORY+" TEXT );";


    public static final String TABLE_SCORE="score";
    public static final String SCORE_KEY_ID="id";
    public static final String SCORE_KEY_CATEGORY="category";
    public static final String SCORE_KEY_SCORE="score";
    public static final String SCORE_KEY_SECTION="section";

//    private SQLiteDatabase database;

    //Constructor

    public DbHelper (@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

//        database = db;

//        String sql1 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST1 + " ( " +
//                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +KEY_QUESTION +
//                "TEXT, " +KEY_OPTIONA+ "TEXT, " +KEY_OPTIONB + "TEXT,"
//                +KEY_OPTIONC+ "TEXT, "  +KEY_OPTIOND+ "TEXT, " + KEY_ANSWER + " TEXT, "+KEY_CATEGORY+ "TEXT)";
//        db.execSQL(sql1);

        db.execSQL(SQL_CREATE_QUERY);
//        addQuestionQuest_data();

        //....same for the other Quests

       /* String sqlscore = "CREATE TABLE IF NOT EXISTS " + TABLE_SCORE+" ( "
                + SCORE_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SCORE_KEY_SECTION
                + " TEXT, " + SCORE_KEY_CATEGORY+ " TEXT, "+ SCORE_KEY_SCORE+" INTEGER)";
        db.execSQL(sqlscore);*/

    }


    public void addQuestionQuest1 (QuestionQuest1 quest) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, quest.getQUESTION());
        values.put(KEY_OPTIONA, quest.getOPTIONA());
        values.put(KEY_OPTIONB, quest.getOPTIONB());
        values.put(KEY_OPTIONC, quest.getOPTIONC());
        values.put(KEY_OPTIOND, quest.getOPTIOND());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_CATEGORY,quest.getCATEGORY());
        // Inserting Row
//        database.insert(TABLE_QUEST1, null, values);
        db.insert(DATABASE_NAME,null,values);
    }



    private void addQuestionQuest_data() {

       //Every Quest has 15 questions

            QuestionQuest1 q1 = new QuestionQuest1("To distribute your application to different platforms, how many Java versions do you need to create?","Just one version","Two versions","One for each platform","Three versions","Just one version","A");
            this.addQuestionQuest1(q1);

            QuestionQuest1 q2 = new QuestionQuest1("Which one of the following statements is true?","Java is used only in NASA's applications","Java is used only for mobile applications","Java is used only for web applications","Java has a huge developer community","Java has a huge developer community","A");
            this.addQuestionQuest1(q2);

            QuestionQuest1 q3 = new QuestionQuest1("Java is a: ","procedural programming language","object-oriented scripting language","object-oriented programming language","high-level and general-purpose programming language","object-oriented programming language","A");
            this.addQuestionQuest1(q3);

            QuestionQuest1 q4 = new QuestionQuest1("Which method is the starting point for all Java programs?","println()","size()","main()","clear()","main()","A");
            this.addQuestionQuest1(q4);

            QuestionQuest1 q5 = new QuestionQuest1("To run a program, the main() method must be identical to this signature:","public static void main(String[] args)","private static void main(String[] args)","private void main(String[] args)","public void main(String[] args)","public static void main(String[] args)","A");
            this.addQuestionQuest1(q5);

            QuestionQuest1 q6 = new QuestionQuest1("What's the meaning of private parameter in a method?","The name of the method","Anyone can access it","Only the class in which it is declared can see it","Doesn't return any value","Only the class in which it is declared can see it","A");
            this.addQuestionQuest1(q6);

            QuestionQuest1 q7 = new QuestionQuest1("What's the meaning of public parameter in a method?","Anyone can access it","Only the class in which it is declared can see it","Doesn't return any value","The name of the method","Anyone can access it","A");
            this.addQuestionQuest1(q7);

            QuestionQuest1 q8 = new QuestionQuest1("What's the meaning of static parameter in a method?","Doesn't return any value","Anyone can access it","Method can be run without creating an instance of the class containing the main method","The name of the method","Method can be run without creating an instance of the class containing the main method","A");
            this.addQuestionQuest1(q8);

            QuestionQuest1 q9 = new QuestionQuest1("Which method prints text in a Java program?","System.out()","out.getText()","System.out.println()","System.printText()","System.out.println()","A");
            this.addQuestionQuest1(q9);

            QuestionQuest1 q10 = new QuestionQuest1("Single-line comments are created into programs using:","// characters at the beginning of the line","// characters at the end of the line","/* characters at the beginning of the line","** characters at the beginning of the line","// characters at the beginning of the line","A");
            this.addQuestionQuest1(q10);


    }


   //we have to put category because we will have other quests in the feature and we will have to sort out the questions by category

    public List<QuestionQuest1> getAllQuestions(String category)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        List<QuestionQuest1> questionList1 = new ArrayList<>();
//        String selectQuery1 = "SELECT  * FROM " + name + " WHERE " + KEY_CATEGORY + " = " + category ;


        String[] column = { KEY_CATEGORY, KEY_ANSWER, KEY_OPTIOND, KEY_OPTIONC, KEY_OPTIONB, KEY_QUESTION, KEY_OPTIONA};
        String where = "KEY_CATEGORY = ?";
        String[] whereArgs = {category};
        Cursor cursor = db.query(DATABASE_NAME,
                column,
                where,
                whereArgs,
                null,
                null,
                null,
                null
                );


//        Cursor cursor = database.rawQuery(selectQuery1, null);
//        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionQuest1 quest1 = new QuestionQuest1();
                quest1.setID(cursor.getInt(0));
                quest1.setQUESTION(cursor.getString(1));
                quest1.setANSWER(cursor.getString(2));
                quest1.setOPTIONA(cursor.getString(3));
                quest1.setOPTIONB(cursor.getString(4));
                quest1.setOPTIONC(cursor.getString(5));
                quest1.setOPTIOND(cursor.getString(6));
                questionList1.add(quest1);
            } while (cursor.moveToNext());
        }
//        // return quest list, for Quest1
        return questionList1;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
