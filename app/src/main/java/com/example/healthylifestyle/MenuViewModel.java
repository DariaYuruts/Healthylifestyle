package com.example.healthylifestyle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.healthylifestyle.Information.Menu;
import com.example.healthylifestyle.Information.MenuDatabase;
import com.example.healthylifestyle.data_layer.MenuCallback;
import com.example.healthylifestyle.data_layer.MenuRepository;

import java.util.Arrays;

public class MenuViewModel extends ViewModel {
    public MenuViewModel() {}

    private MutableLiveData<Menu[]> _menus;

    private final MenuRepository repository = new MenuRepository();

    public LiveData<Menu[]> getMenuArray(String type) {
        if (_menus == null) {
            _menus = new MutableLiveData<>();
            loadMenuArray(type);
        }
        return _menus;
    }

    private void loadMenuArray(String type) {
        repository.getDatabaseMenu(new MenuCallback() {
            @Override
            public void processData(MenuDatabase[] menuDatabases) {
                Menu[] menuArray = new Menu[menuDatabases.length];
                for (int i = 0; i < menuDatabases.length; ++i) {
                    MenuDatabase menuDatabase = menuDatabases[i];
                    menuArray[i] = new Menu(
                            menuDatabase.getBreakfast(),
                            menuDatabase.getLunch(),
                            menuDatabase.getAfternoonSnack(),
                            menuDatabase.getDinner(),
                            getBitmapFromString(menuDatabase.getImage())
                    );
                }
                _menus.postValue(menuArray);
            }

            @Override
            public void throwException(String message) {
                Log.e("ERROR", message);
            }
        }, type);
    }

    private Bitmap getBitmapFromString(String string) {
        if (string == null) return null;
        byte[] array = new byte[0];
        String[] newString = string.replace("[", "").replace("]", "").replace(",", "").split(" ");
        Integer[] intArray = Arrays.stream(newString).map(Integer::parseInt).toArray(Integer[]::new);
        array = new byte[intArray.length];
        for (int i = 0; i < intArray.length; ++i) {
            array[i] = (byte) intArray[i].intValue();
        }
        return BitmapFactory.decodeByteArray(array, 0, array.length);
    }
}
