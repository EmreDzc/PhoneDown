package com.example.phonedown.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.phonedown.data.model.Room;
import com.example.phonedown.data.repository.RoomRepository;
import com.example.phonedown.util.DataCallback;
public class HomeViewModel extends ViewModel{
    private final RoomRepository repository;
    private final MutableLiveData<Room> createdRoom = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public HomeViewModel(){
        repository = RoomRepository.getInstance();
    }

    public void createRoom(String nickname){
        isLoading.setValue(true);
        repository.createRoom(nickname, new DataCallback<Room>() {
            @Override
            public void onSuccess(Room room) {
                isLoading.setValue(false);
                createdRoom.setValue(room);
            }

            @Override
            public void onError(String error) {
                isLoading.setValue(false);
                errorMessage.setValue(error);
            }
        });
    }

    public MutableLiveData<Room> getCreatedRoom() { return createdRoom; }
    public MutableLiveData<String> getErrorMessage() { return errorMessage; }
    public MutableLiveData<Boolean> getIsLoading() { return isLoading; }

}
