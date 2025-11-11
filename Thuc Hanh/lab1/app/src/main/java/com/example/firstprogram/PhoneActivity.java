package com.example.firstprogram;

// Các import này được lấy từ ảnh 581add.png
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

// Các import này cần thiết cho code trong các ảnh sau
import android.content.Intent;
import android.view.View;

public class PhoneActivity extends AppCompatActivity {

    // Khai báo biến (từ ảnh 581add.png)
    EditText txtPhone;
    Button btnCall, btnSendSMS;
    private static final int REQUEST_CALL_PHONE = 1;
    private static final int REQUEST_SEND_SMS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        // Ánh xạ view (từ ảnh 581add.png)
        txtPhone = findViewById(R.id.txtPhone);
        btnCall = findViewById(R.id.btnCall);
        btnSendSMS = findViewById(R.id.btnSendSMS);

        // Gán sự kiện click (hoàn thiện từ ảnh 581add.png)
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });

        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
    }

    // Phương thức makePhoneCall (từ ảnh 581b3b.png)
    private void makePhoneCall() {
        String phoneNumber = txtPhone.getText().toString().trim();
        if (phoneNumber.isEmpty()) {
            Toast.makeText(this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(callIntent);
        }
    }

    // Phương thức sendSMS (từ ảnh 581b5c.png)
    private void sendSMS() {
        String phoneNumber = txtPhone.getText().toString().trim();
        if (phoneNumber.isEmpty()) {
            Toast.makeText(this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.SEND_SMS}, REQUEST_SEND_SMS);
        } else {
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, "Hello from Lab1!", null, null);
                Toast.makeText(this, "SMS sent", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Failed to send SMS", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Phương thức onRequestPermissionsResult (từ ảnh 581b99.png)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Call permission denied", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_SEND_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendSMS();
            } else {
                Toast.makeText(this, "Send SMS permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

