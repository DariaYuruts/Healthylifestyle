package com.example.healthylifestyle;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthylifestyle.Information.User;
import com.example.healthylifestyle.utils.NoRememberedUserException;
import com.example.healthylifestyle.utils.PreferenceConstants;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btnSign, btnRegister;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (getEmailAndPassword() != null) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                finish();
            }
        } catch (NoRememberedUserException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_main);

        btnSign = findViewById(R.id.button_start);
        btnRegister = findViewById(R.id.button_register);

        root = findViewById(R.id.main);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        btnRegister.setOnClickListener(v -> showRegisterWindow());
        btnSign.setOnClickListener(v -> showSignWindow());
    }

    private void showSignWindow() {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Войти");
            dialog.setMessage("Введите данные для входа");

            LayoutInflater inflater = LayoutInflater.from(this);
            View sign_window = inflater.inflate(R.layout.signstart, null);
            dialog.setView(sign_window);

            final EditText email = sign_window.findViewById(R.id.email);
            final EditText pass = sign_window.findViewById(R.id.pass);
            final CheckBox rememberToggle = sign_window.findViewById(R.id.checkbox_remember);

            dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if(TextUtils.isEmpty(email.getText().toString())){
                        Snackbar.make(root,"Введите корректный адрес почты", Snackbar.LENGTH_SHORT).show();
                        return;
                    }

                    if(pass.getText().toString().length() < 6){
                        Snackbar.make(root,"Введите пароль не менее 6 символов", Snackbar.LENGTH_SHORT).show();
                        return;
                    }
                    auth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    if (rememberToggle.isChecked()) {
                                        rememberUser(email.getText().toString(), pass.getText().toString());
                                    }
                                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                                    finish();
                                }
                            }).addOnFailureListener(e -> Snackbar.make(root,"Ошибка авторизации" + e.getMessage(), Snackbar.LENGTH_SHORT).show());
                }
            });

            dialog.show();
    }

    private void showRegisterWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Регистрация");
        dialog.setMessage("Введите все данные для регистрации");
        LayoutInflater inflater = LayoutInflater.from(this);
        View register_window = inflater.inflate(R.layout.register, null);
        dialog.setView(register_window);
        final EditText email = register_window.findViewById(R.id.email);
        final EditText pass = register_window.findViewById(R.id.pass);
        final EditText name = register_window.findViewById(R.id.name);
        final EditText surname = register_window.findViewById(R.id.surname);
        final EditText ageInput = register_window.findViewById(R.id.ageInput);
        final EditText heightInput = register_window.findViewById(R.id.heightInput);
        final EditText weightInput = register_window.findViewById(R.id.weightInput);
        final Spinner sexInput = register_window.findViewById(R.id.sex_choice);
        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root,"Введите корректный адрес почты", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(pass.getText().toString().length() < 6 ){
                    Snackbar.make(root,"Введите пароль не менее 6 символов", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name.getText().toString())){
                    Snackbar.make(root,"Введите ваше имя", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(surname.getText().toString())){
                    Snackbar.make(root,"Введите вашу фамилию", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(ageInput.getText().toString())){
                    Snackbar.make(root,"Введите ваш возраст", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(heightInput.getText().toString())){
                    Snackbar.make(root,"Введите ваш рост", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(weightInput.getText().toString())){
                    Snackbar.make(root,"Введите ваш вес", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                        .addOnSuccessListener(authResult -> {
                            String enteredName = name.getText().toString();
                            String enteredSurname = surname.getText().toString();
                            String enteredEmail = email.getText().toString();
                            String enteredPassword = pass.getText().toString();
                            String enteredAge = ageInput.getText().toString();
                            String enteredHeight = heightInput.getText().toString();
                            String enteredWeight = weightInput.getText().toString();
                            String chosenSex = sexInput.getItemAtPosition(sexInput.getSelectedItemPosition()).toString();
                            User user = new User(
                                    enteredName,
                                    enteredSurname,
                                    enteredEmail,
                                    enteredPassword,
                                    enteredAge,
                                    enteredHeight,
                                    enteredWeight,
                                    chosenSex
                            );
                            users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Snackbar.make(root, "Пользователь добавлен!", Snackbar.LENGTH_SHORT).show();
                                        }
                                    });
                        }).addOnFailureListener(e -> Snackbar.make(root, "Ошибка!" + e.getMessage(), Snackbar.LENGTH_LONG).show());
            }
        });
        dialog.show();
    }

    void rememberUser(String email, String password) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences(PreferenceConstants.FILE_NAME, MODE_PRIVATE);
        preferences.edit()
                .putString(PreferenceConstants.EMAIL, email)
                .putString(PreferenceConstants.PASSWORD, password)
                .apply();
    }

    Pair<String, String> getEmailAndPassword() throws NoRememberedUserException {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences(PreferenceConstants.FILE_NAME, MODE_PRIVATE);
        String email = preferences.getString(PreferenceConstants.EMAIL, null);
        String password = preferences.getString(PreferenceConstants.PASSWORD, null);
        if (email == null || password == null) throw new NoRememberedUserException("Email or password not remembered");
        return Pair.create(email, password);
    }
}