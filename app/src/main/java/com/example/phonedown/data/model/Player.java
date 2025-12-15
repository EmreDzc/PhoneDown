package com.example.phonedown.data.model;

public class Player {
    private String uid;
    private String nickname;
    private boolean isHost;
    private String state;

    public Player(){

    }

    public Player(String uid, String nickname, boolean isHost){
        this.uid = uid;
        this.nickname = nickname;
        this.isHost = isHost;
        this.state = "ALIVE";
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isHost() {
        return isHost;
    }

    public void setHost(boolean host) {
        isHost = host;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
