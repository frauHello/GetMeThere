package com.example.user.getmethere;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class SignupActivity extends AppCompatActivity {
    SqlConnect sql = new SqlConnect(this);
    private static final String TAG = "SignupActivity";
    EditText  _nameText,_addressText,_emailText,_mobileText,_passwordText,_reEnterPasswordText ;
    Button _signupButton ; TextView _loginLink;
    String name, address,email,mobile, password,reEnterPassword;
    //Account account;

    // define constants for accounts table
    public static final String ACCOUNTS_TABLE_NAME = "accounts";

    public static final String ACCOUNTS_COLUMN_NAME = "name";
    public static final String ACCOUNTS_COLUMN_PASSWORD = "account_password";
    public static final String ACCOUNTS_COLUMN_EMAIL = "email";
    public static final String ACCOUNTS_COLUMN_ADRESSE = "adress";
    public static final String ACCOUNTS_COLUMN_PHONE = "phone_num";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //s=new Account();

        try
        {
            SqlConnect.myInput = getAssets().open(SqlConnect.DB_NAME);
            this.sql.createDataBase();
            SqlConnect.openDataBase();

        }
        catch (IOException localIOException) {
        }
        _signupButton =  (Button)findViewById(R.id.btn_signup);
        _loginLink =  (TextView) findViewById(R.id.link_login);
        _nameText = (EditText) findViewById(R.id.input_name);
        _addressText = (EditText) findViewById(R.id.input_address);
        _emailText = (EditText) findViewById(R.id.input_email);
        _mobileText = (EditText) findViewById(R.id.input_mobile);
        _passwordText = (EditText) findViewById(R.id.input_password);
        _reEnterPasswordText = (EditText) findViewById(R.id.input_reEnterPassword);
        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
            }
    public void signup() {

        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

       /* String name = _nameText.getText().toString();
        String address = _addressText.getText().toString();
        String email = _emailText.getText().toString();
        String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();*/

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success

                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ACCOUNTS_COLUMN_NAME, name);
        contentValues.put(ACCOUNTS_COLUMN_EMAIL, email);
        contentValues.put(ACCOUNTS_COLUMN_PASSWORD, password);
        contentValues.put(ACCOUNTS_COLUMN_ADRESSE, address);
        contentValues.put(ACCOUNTS_COLUMN_PHONE, mobile);
        SqlConnect.Insert_Data(ACCOUNTS_TABLE_NAME,null,contentValues);


        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Account No Created", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }
    public boolean validate() {
        boolean valid = true;
         name = _nameText.getText().toString();
         address = _addressText.getText().toString();
         email = _emailText.getText().toString();
         mobile = _mobileText.getText().toString();
         password = _passwordText.getText().toString();
         reEnterPassword = _reEnterPasswordText.getText().toString();


        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (address.isEmpty()) {
            _addressText.setError("Enter Valid Address");
            valid = false;
        } else {
            _addressText.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (mobile.isEmpty() || mobile.length()!=8) {
            _mobileText.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            _mobileText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            _reEnterPasswordText.setError("Password Do not match");
            valid = false;
        } else {
            _reEnterPasswordText.setError(null);
        }

        //account = new Account(name,reEnterPassword,email,address,mobile,password);
        return valid;
    }

    }


