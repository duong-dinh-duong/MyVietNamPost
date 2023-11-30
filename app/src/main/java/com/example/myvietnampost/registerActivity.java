package com.example.myvietnampost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registerActivity extends AppCompatActivity {
    private TextInputEditText Email,password,SDT,Huyen,Xa,Tinh,DCCT,HT,password2;
    private Button btnR;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private ImageView btnLogin;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUi();
        initListener();
    }




    private void initUi() {
        Email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        SDT =findViewById(R.id.etSDT);
        DCCT =findViewById(R.id.DCCT);
        Tinh =findViewById(R.id.T_TP);
        Huyen =findViewById(R.id.Q_H);
        Xa =findViewById(R.id.P_X);
        HT =findViewById(R.id.etHT);
        password2 =findViewById(R.id.etPassword2);
        btnR = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        progressDialog = new ProgressDialog(this);
    }
    private void initListener() {
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSignUP();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registerActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    private void onClickSignUP(){

        String strEmail  = Email.getText().toString().trim();
        String strSDT = SDT.getText().toString().trim();
        String strHT = HT.getText().toString().trim();
        String strDCCT = DCCT.getText().toString().trim();
        String strHuyen = Huyen.getText().toString().trim();
        String strTinh = Tinh.getText().toString().trim();
        String strXa = Xa.getText().toString().trim();
        String strPassword = password.getText().toString().trim();
        String strPassword2 = password2.getText().toString().trim();
        if(TextUtils.isEmpty(strHT))
        {
            Toast.makeText(registerActivity.this, "chưa nhập họ và tên", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(strSDT))
        {
            Toast.makeText(registerActivity.this, "chưa nhập số điên thoại", Toast.LENGTH_SHORT).show();
            return;
        }
        if (SDT.length()<10 || SDT.length()>10) {
            Toast.makeText(registerActivity.this, "số điện thoại không đúng định dạng", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(strDCCT))
        {
            Toast.makeText(registerActivity.this, "chưa nhập đia chỉ chi tiết", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(strHuyen))
        {
            Toast.makeText(registerActivity.this, "chưa nhập Quận/Huyên", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(strTinh))
        {
            Toast.makeText(registerActivity.this, "chưa nhập Tinh/Thanh phố", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(strXa))
        {
            Toast.makeText(registerActivity.this, "chưa nhập Xã/Phường ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(strPassword) )
        {
            Toast.makeText(registerActivity.this, "chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }
        if (strPassword.length()<6) {
            Toast.makeText(registerActivity.this, "Mật Khẩu phải ít nhất 6 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(strPassword2))
        {
            Toast.makeText(registerActivity.this, "chưa nhập lại mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }
        if(strPassword.compareTo(strPassword2)!=0){
            Toast.makeText(registerActivity.this, "mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.show();
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(strEmail, strPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            Uesr uesr = new Uesr(strHT,strSDT,strEmail,strDCCT,strTinh,strHuyen,strXa);
                            mDatabase.child(strSDT).setValue(uesr);
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(registerActivity.this,MainActivity.class);
                            startActivity(intent);
                            finishAffinity();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(registerActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }






}