package com.example.sebat.resume;

/**
 * Created by Sebat on 11/7/2015.
 */
public class Teams {

    private int teamNumber;
    private String title;
    private String description;


    public Teams(int teamNumber, String title, String description) {
        this.teamNumber = teamNumber;
        this.title = title;
        this.description = description;

    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return title;
    }
}
