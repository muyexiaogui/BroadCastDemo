package lhx.com.practicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lhx.com.practicedemo.utils.BaseActivity;

public class LoginActivity extends BaseActivity {

    private Button loginBtn;
    private EditText accountEd,passWordEd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = (Button)findViewById(R.id.login);
        accountEd = (EditText)findViewById(R.id.account);
        passWordEd = (EditText)findViewById(R.id.password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEd.getText().toString().trim();
                String passWord = passWordEd.getText().toString().trim();
                if(account.equals("admin") && passWord.equals("admin")){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"账户名密码不正确",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
