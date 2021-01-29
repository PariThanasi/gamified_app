package gr.hua.thesis.parith.gamifiedlearningapp;

public class User {
   // public String username, email;
    private String username;
    private String email;
    private long createdAt;
    public int compMarksE=0;
    public int hardwareMarksE=0;
    public int osMarksE=0;
    public int finalMarks=0;

    private String mRecipientId;


    public User() {
    }

    public User(String displayName, String email,long createdAt,int compMarksB,int compMarksI,int compMarksE,int hardwareMarksB,int hardwareMarksI,int hardwareMarksE,int osMarksB,int osMarksI,int osMarksE,int finalMarks) {

        this.email = email;
        this.createdAt = createdAt;
        this.compMarksE=compMarksE;

        this.hardwareMarksE=hardwareMarksE;

        this.osMarksE=osMarksE;
        this.finalMarks=finalMarks;
    }



    public int getCompMarksE() {
        return compMarksE;
    }

    public void setCompMarksE(int compMarksE) {
        this.compMarksE = compMarksE;
    }


    public int getHardwareMarksE() {
        return hardwareMarksE;
    }

    public void setHardwareMarksE(int hardwareMarksE) {
        this.hardwareMarksE = hardwareMarksE;
    }


    public int getOsMarksE() {
        return osMarksE;
    }

    public void setOsMarksE(int osMarksE) {
        this.osMarksE = osMarksE;
    }

    public int getFinalMarks() {
        return finalMarks;
    }

    public void setFinalMarks(int finalMarks) {
        this.finalMarks = finalMarks;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    private String getUserEmail() {
        //Log.e("user email  ", userEmail);
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public String getRecipientId() {
        return mRecipientId;
    }

    public void setRecipientId(String recipientId) {
        this.mRecipientId = recipientId;
    }
}



