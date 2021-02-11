package gr.hua.thesis.parith.gamifiedlearningapp;

public class User {

    private String username;
    private String email;
    public int quest1Points=0;


    public User (String username, String email,int quest1Points) {
        this.username = username;
        this.email = email;
        this.quest1Points= quest1Points;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getQuest1Points() {
        return quest1Points;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQuest1Points(int quest1Points) {
        this.quest1Points = quest1Points;
    }
}



