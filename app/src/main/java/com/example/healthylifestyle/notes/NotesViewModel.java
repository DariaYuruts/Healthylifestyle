package com.example.healthylifestyle.notes;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.healthylifestyle.Information.BMI;
import com.example.healthylifestyle.Information.CPFC;
import com.example.healthylifestyle.Information.Water;
import com.example.healthylifestyle.data_layer.BMICallback;
import com.example.healthylifestyle.data_layer.CPFCCallback;
import com.example.healthylifestyle.data_layer.IndexRepository;
import com.example.healthylifestyle.data_layer.WaterBalanceCallback;

public class NotesViewModel extends ViewModel {
    public NotesViewModel() {}

    private MutableLiveData<BMI> _bmi;
    private MutableLiveData<CPFC> _cpfc;
    private MutableLiveData<Water> _water;
    private final IndexRepository repository = new IndexRepository();

    public LiveData<BMI> getCurrentUserBMI() {
        if (_bmi == null) {
            _bmi = new MutableLiveData<>();
            loadCurrentUserBMI();
        }
        return _bmi;
    }

    public LiveData<CPFC> getCurrentUserCPFC() {
        if (_cpfc == null) {
            _cpfc = new MutableLiveData<>();
            loadCurrentUserCPFC();
        }
        return _cpfc;
    }

    public LiveData<Water> getCurrentUserWater() {
        if (_water == null) {
            _water = new MutableLiveData<>();
            loadCurrentUserWaterBalance();
        }
        return _water;
    }

    private void loadCurrentUserBMI() {
        repository.getCurrentUserBMI(new BMICallback() {
            @Override
            public void processData(BMI bmi) {
                _bmi.postValue(bmi);
            }

            @Override
            public void throwException(String message) {
                Log.e("ERROR", message);
            }
        });
    }

    private void loadCurrentUserCPFC() {
        repository.getCurrentUserCPFC(new CPFCCallback() {
            @Override
            public void processData(CPFC cpfc) {
                _cpfc.postValue(cpfc);
            }

            @Override
            public void throwException(String message) {
                Log.e("ERROR", message);
            }
        });
    }

    private void loadCurrentUserWaterBalance() {
        repository.getCurrentUserWaterBalance(new WaterBalanceCallback() {
            @Override
            public void processData(Water water) {
                _water.postValue(water);
            }

            @Override
            public void throwException(String message) { Log.e("ERROR", message);}
        });
    }
}
