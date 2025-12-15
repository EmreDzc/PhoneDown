package com.example.phonedown.data.model;
import java.util.HashMap;
import java.util.Map;
public class Room {
    private String roomId;
    private String status;
    private long startTime;
    private Map<String, Player> players = new HashMap<>();

    public Room(){

    }
    public Room(String roomId){
        this.roomId = roomId;
        this.status = "WAITING";
        this.startTime = 0;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = players;
    }
}
