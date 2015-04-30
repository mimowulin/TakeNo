package com.lin.mimo.takeno;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class LogActivity extends ActionBarActivity {
    String strname, strpassword, strpassword2, stremail;
    EditText edname, edpassword, edpassword2, edemail;
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
         edname = (EditText)findViewById(R.id.name);
         edpassword = (EditText)findViewById(R.id.password);
         edpassword2 = (EditText)findViewById(R.id.password2);
         edemail = (EditText)findViewById(R.id.email);
        test = (TextView)findViewById(R.id.textView8);
        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strname = edname.getText().toString();
                strpassword = edpassword.getText().toString();
                strpassword2 = edpassword2.getText().toString();
                stremail = edemail.getText().toString();
                //test.setText(edemail.getText().toString());
                if(!strpassword.equals(strpassword2)){
                    Toast toast = Toast.makeText(LogActivity.this,"密碼不一樣喔!",Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    ParseUser parseUser = new ParseUser();
                    parseUser.setUsername(strname);
                    parseUser.setPassword(strpassword);
                    parseUser.setEmail(stremail);
                    parseUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null){
                                Toast.makeText(LogActivity.this,"註冊成功!",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(LogActivity.this,"失敗!請檢查!",Toast.LENGTH_LONG).show();
                                String s = String.valueOf(e.getCode());
                                test.setText(s);
                            }
                        }
                    });
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
