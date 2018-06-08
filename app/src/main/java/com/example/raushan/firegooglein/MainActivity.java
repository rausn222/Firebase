package com.example.raushan.firegooglein;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener {
    SignInButton button;
    FirebaseAuth mAuth;
    Button b1,b2,b3,b4;
    TextView tv,tv1;
    String name;
    private final static int RC_SIGN_IN = 7;
    GoogleApiClient mGoogleApiClient;
    public static final String TAG = "MAIN_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (SignInButton)findViewById(R.id.googleBtn);
        tv = (TextView)findViewById(R.id.textView9);
        tv1 = (TextView)findViewById(R.id.textView8);
        b1 = (Button)findViewById(R.id.button7);
        b2 = (Button)findViewById(R.id.button9);
        b3 = (Button)findViewById(R.id.button10);
        b4 = (Button)findViewById(R.id.button11);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        button.setOnClickListener(this);
        button.setVisibility(View.GONE);
        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();
        signIn();
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button7:
                startActivity(new Intent(MainActivity.this,Property_type.class));
                break;
            case R.id.button9:
                Intent i = new Intent(MainActivity.this,Summery.class);
                i.putExtra("name",name);
                startActivity(i);
                break;
            case R.id.button10:
                break;
            case R.id.button11:
                signOut();
                break;
            case R.id.googleBtn:
                signIn();
                break;
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    public void signOut(){
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI(false);
            }
        });
    }
    public void handleResult(GoogleSignInResult result)
    {
        if (result.isSuccess())
        {
            GoogleSignInAccount account = result.getSignInAccount();
                name = account.getDisplayName();
                tv.setText("Welcome: " + name);
                updateUI(true);
        }
        else {
            updateUI(false);
        }
    }
    public void updateUI(boolean isLogin)
    {
        if (isLogin)
        {
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);
            tv.setVisibility(View.VISIBLE);
            tv1.setVisibility(View.VISIBLE);
            button.setVisibility(View.GONE);
        }
        else {
            b1.setVisibility(View.GONE);
            b2.setVisibility(View.GONE);
            b3.setVisibility(View.GONE);
            b4.setVisibility(View.GONE);
            tv1.setVisibility(View.GONE);
            tv.setVisibility(View.GONE);
            button.setVisibility(View.VISIBLE);
        }
    }
}
