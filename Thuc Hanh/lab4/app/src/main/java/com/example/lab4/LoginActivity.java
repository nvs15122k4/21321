package com.example.lab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


public class LoginActivity extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    View btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            showCustomToast();

            // Sau khi hiện Toast, chuyển sang MainActivity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

    private void showCustomToast() {
        String email = edtEmail.getText().toString().trim();
        String pass = edtPassword.getText().toString().trim();

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, findViewById(android.R.id.content), false);

        ImageView img = layout.findViewById(R.id.img_toast);
        img.setImageResource(R.drawable.ic_check);

        TextView text = layout.findViewById(R.id.txt_toast);
        text.setText("Bạn đã đăng nhập thành công với email: " + email + " và mật khẩu: " + pass);

        Toast toast = new Toast(LoginActivity.this);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}
