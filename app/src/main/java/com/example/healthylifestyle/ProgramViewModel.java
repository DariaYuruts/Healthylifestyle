package com.example.healthylifestyle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.healthylifestyle.Information.Exercise;
import com.example.healthylifestyle.Information.ExerciseDatabase;
import com.example.healthylifestyle.data_layer.ExerciseCallback;
import com.example.healthylifestyle.data_layer.ExerciseRepository;

import java.util.Arrays;

public class ProgramViewModel extends ViewModel {
    public ProgramViewModel() {}

    private MutableLiveData<Exercise[]> _exercises;
    private final ExerciseRepository repository = new ExerciseRepository();

    public LiveData<Exercise[]> getExercises(String part) {
        if (_exercises == null) {
            _exercises = new MutableLiveData<>();
            loadExercises(part);
        }
        return _exercises;
    }

    private void loadExercises(String part) {
        repository.getDatabaseExercise(new ExerciseCallback() {
            @Override
            public void processData(ExerciseDatabase[] exercises) {
                Exercise[] exerciseArray = new Exercise[exercises.length];
                for (int i = 0; i < exerciseArray.length; ++i) {
                    ExerciseDatabase exerciseDatabase = exercises[i];
                    exerciseArray[i] = new Exercise(
                            exerciseDatabase.getName(),
                            exerciseDatabase.getText(),
                            exerciseDatabase.getNumber(),
                            getBitmapFromString(exerciseDatabase.getImage())
                    );
                }
                _exercises.postValue(exerciseArray);
            }
            @Override
            public void throwException(String message) {
                Log.e("ERROR", message);
            }
        }, part);
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
