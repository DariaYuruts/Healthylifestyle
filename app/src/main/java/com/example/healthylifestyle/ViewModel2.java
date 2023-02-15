package com.example.healthylifestyle;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.healthylifestyle.Information.User;
import com.example.healthylifestyle.data_layer.UserCallBack;
import com.example.healthylifestyle.data_layer.UserRepository;

public class ViewModel2 extends ViewModel {
    public ViewModel2() {}

    private MutableLiveData<User> _user;
    private final UserRepository repository = new UserRepository();

    public LiveData<User> getCurrentUser() {
        if (_user == null) {
            _user = new MutableLiveData<>();
            loadUser();
        }
        return _user;
    }

    private void loadUser() {
        repository.getCurrentUser(new UserCallBack() {
            @Override
            public void processData(User user) {
                _user.postValue(user);
            }
            @Override
            public void throwException(String message) {
                Log.e("ERROR", message);
            }
        });
    }
}
