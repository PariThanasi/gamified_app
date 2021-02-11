package gr.hua.thesis.parith.gamifiedlearningapp;

public class QuestionQuest1 {

    private int ID;
    private String QUESTION;
    private String OPTIONA;
    private String OPTIONB;
    private String OPTIONC;
    private String OPTIOND;
    private String ANSWER;
    private String CATEGORY;

    public QuestionQuest1 ()
    {
        ID = 0;
        QUESTION = "";
        OPTIONA = "";
        OPTIONB = "";
        OPTIONC = "";
        OPTIOND = "";
        CATEGORY="";
    }
    public QuestionQuest1(String question, String optionA, String optionB, String optionC, String optionD,
                      String answer,String category) {

        QUESTION = question;
        OPTIONA = optionA;
        OPTIONB = optionB;
        OPTIONC = optionC;
        OPTIOND = optionD;
        ANSWER = answer;
        CATEGORY= category;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public int getID() {
        return ID;
    }

    public String getOPTIONA() {
        return OPTIONA;
    }

    public String getOPTIONB() {
        return OPTIONB;
    }

    public String getOPTIONC() {
        return OPTIONC;
    }

    public String getOPTIOND() {
        return OPTIOND;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public void setOPTIONA(String OPTIONA) {
        this.OPTIONA = OPTIONA;
    }

    public void setOPTIONB(String OPTIONB) {
        this.OPTIONB = OPTIONB;
    }

    public void setOPTIONC(String OPTIONC) {
        this.OPTIONC = OPTIONC;
    }

    public void setOPTIOND(String OPTIOND) {
        this.OPTIOND = OPTIOND;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }
}
