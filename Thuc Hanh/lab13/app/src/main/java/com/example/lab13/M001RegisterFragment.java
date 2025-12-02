package com.example.lab13;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class M001RegisterFragment extends Fragment implements View.OnClickListener {

    private EditText edtEmail, edtPass, edtRepass;
    private Context mContext;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m001_frg_register, container, false);

        databaseHelper = new DatabaseHelper(mContext);

        initView(rootView);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initView(View v) {
        edtEmail = v.findViewById(R.id.edt_email);
        edtPass = v.findViewById(R.id.edt_pass);
        edtRepass = v.findViewById(R.id.edt_re_pass);

        v.findViewById(R.id.tv_register).setOnClickListener(this);
        v.findViewById(R.id.iv_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(mContext,
                androidx.appcompat.R.anim.abc_fade_in));

        if (v.getId() == R.id.iv_back) {
            gotoLoginScreen();
        } else if (v.getId() == R.id.tv_register) {
            register(edtEmail.getText().toString(),
                    edtPass.getText().toString(),
                    edtRepass.getText().toString());
        }
    }

    private void gotoLoginScreen() {
        ((MainActivity) mContext).gotoLoginScreen();
    }

    private void register(String mail, String pass, String repass) {
        if (mail.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
            Toast.makeText(mContext, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            Toast.makeText(mContext, "Email không hợp lệ!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass.length() < 6) {
            Toast.makeText(mContext, "Mật khẩu phải có ít nhất 6 ký tự!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pass.equals(repass)) {
            Toast.makeText(mContext, "Mật khẩu không khớp!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (databaseHelper.checkEmail(mail)) {
            Toast.makeText(mContext, "Email đã tồn tại!", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isInserted = databaseHelper.addUser(mail, pass);

        if (isInserted) {
            Toast.makeText(mContext, "Đăng ký tài khoản thành công!", Toast.LENGTH_SHORT).show();
            gotoLoginScreen();
        } else {
            Toast.makeText(mContext, "Đăng ký thất bại! Vui lòng thử lại.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }
}