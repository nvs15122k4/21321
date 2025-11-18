package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnBgSelector, btnBgSelectorDisabled, btnDrawableSelector, btnTxtSelector;
    Button btnRoundShape, btnBgShape, btnSelectorShape, btnLoginDialog, btnSeekbar;
    ImageButton imgButtonLeft, imgButtonRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addControls() {

        btnBgSelector = findViewById(R.id.btnBgSelector);
        btnBgSelectorDisabled = findViewById(R.id.btnBgSelectorDisabled);
        btnDrawableSelector = findViewById(R.id.btnDrawableSelector);
        btnTxtSelector = findViewById(R.id.btnTxtSelector);

        btnRoundShape = findViewById(R.id.btnRoundShape);
        btnBgShape = findViewById(R.id.btnBgShape);
        btnSelectorShape = findViewById(R.id.btnSelectorShape);

        btnLoginDialog = findViewById(R.id.btnLoginDialog);
        btnSeekbar = findViewById(R.id.btnSeekbar);

        // Nếu bạn có 2 emoji → phải đặt 2 id trong XML
        imgButtonLeft = findViewById(R.id.imgButtonLeft);
        imgButtonRight = findViewById(R.id.imgButtonRight);
    }

    private void addEvents() {

        btnBgSelector.setOnClickListener(v -> showToast("Colored Selector clicked"));
        btnBgSelectorDisabled.setOnClickListener(v -> showToast("Disabled button clicked"));
        btnDrawableSelector.setOnClickListener(v -> showToast("Drawable selector clicked"));
        btnTxtSelector.setOnClickListener(v -> showToast("Made by VSang"));

        btnRoundShape.setOnClickListener(v -> showToast("Round shape clicked"));
        btnBgShape.setOnClickListener(v -> showToast("Gradient shape clicked"));
        btnSelectorShape.setOnClickListener(v -> showToast("Selector shape clicked"));

        imgButtonLeft.setOnClickListener(v -> showToast("Left emoji clicked"));
        imgButtonRight.setOnClickListener(v -> showToast("Right emoji clicked"));

        btnLoginDialog.setOnClickListener(v -> openLoginDialog());

        btnSeekbar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SeekBarActivity.class);
            startActivity(intent);
        });
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void openLoginDialog() {
        Dialog d = new Dialog(MainActivity.this);
        d.setContentView(R.layout.custom_login_dialog);
        d.setCancelable(true);

        EditText edtUser = d.findViewById(R.id.edtUser);
        EditText edtPass = d.findViewById(R.id.edtPass);
        Button btnOK = d.findViewById(R.id.btnOK);
        Button btnCancel = d.findViewById(R.id.btnCancel);

        btnOK.setOnClickListener(v -> {
            String u = edtUser.getText().toString().trim();
            String p = edtPass.getText().toString().trim();

            if (u.equals("admin") && p.equals("123")) {
                Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                d.dismiss();
            } else {
                Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(v -> d.dismiss());

        d.show();
        Window window = d.getWindow();
        if (window != null) {
            window.setLayout(
                    (int) (getResources().getDisplayMetrics().widthPixels * 0.85),
                    WindowManager.LayoutParams.WRAP_CONTENT
            );
        }
    }
}
