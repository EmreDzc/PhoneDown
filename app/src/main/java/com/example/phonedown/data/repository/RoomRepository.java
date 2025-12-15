package com.example.phonedown.data.repository;

import com.example.phonedown.data.model.Player;
import com.example.phonedown.data.model.Room;
import com.example.phonedown.util.DataCallback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;
import java.util.UUID;
public class RoomRepository {
    private static RoomRepository instance;
    private final DatabaseReference roomsRef;

    private RoomRepository(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        this.roomsRef = database.getReference("rooms");
    }

    public static synchronized RoomRepository getInstance() {
        if(instance == null){
            instance = new RoomRepository();
        }
        return instance;
    }

    public void createRoom(String nickname, DataCallback<Room> callback){
        String roomId = String.valueOf(100000 + new Random().nextInt(900000));
        String userId = UUID.randomUUID().toString();
        Player hostPlayer = new Player(userId,nickname,true);

        Room newRoom = new Room(roomId);
        newRoom.getPlayers().put(userId,hostPlayer);

        roomsRef.child(roomId).setValue(newRoom)
                .addOnSuccessListener(aVoid -> {
                    // Başarılı olursa oluşturulan odayı geri döndür
                    callback.onSuccess(newRoom);
                })
                .addOnFailureListener(e -> {
                    // Hata olursa mesajı döndür
                    callback.onError(e.getMessage());
                });
    }
}
