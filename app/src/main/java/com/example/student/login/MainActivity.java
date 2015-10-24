package com.example.student.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.login.util.Preference;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private Button mButton;
    private TextView mTextMessage;
    private EditText mEditText1;
    private EditText mEditText2;
    private EditText mEditText3;
    private EditText mEditText4;
    private ArrayList<Integer> _pwd = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Preference pf = new Preference();


        mButton = (Button) findViewById(R.id.button);
        mTextMessage = (TextView) findViewById(R.id.textMessage);
        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
        mEditText3 = (EditText) findViewById(R.id.editText3);
        mEditText4 = (EditText) findViewById(R.id.editText4);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kara_check(mEditText1) && kara_check(mEditText2) && kara_check(mEditText3)
                        && kara_check(mEditText4)) {
                    set_pwd(Integer.parseInt(String.valueOf(mEditText1.getText())));
                    set_pwd(Integer.parseInt(String.valueOf(mEditText2.getText())));
                    set_pwd(Integer.parseInt(String.valueOf(mEditText3.getText())));
                    set_pwd(Integer.parseInt(String.valueOf(mEditText4.getText())));
//                    mTextMessage.setText( get_pwd());
                    pf.putLoginPassword(getApplicationContext(),get_pwd().replaceAll("[^0-9]",""));
                    showToast(pf.getLoginPassword(getApplicationContext()));

                } else {
                    mEditText1.setText("");
                    mEditText2.setText("");
                    mEditText3.setText("");
                    mEditText4.setText("");
                    mTextMessage.setText("入力エラーだよ");
                    reset_pwd();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void reset_pwd() {
        this._pwd.clear();
    }

    public String get_pwd() {
        return this._pwd.toString();
    }

    public void set_pwd(int num) {
        this._pwd.add(num);
    }


    public boolean kara_check(EditText editText) {
        if (editText.getText().toString().equals("")) {
            return false;
        }
        return true;
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
