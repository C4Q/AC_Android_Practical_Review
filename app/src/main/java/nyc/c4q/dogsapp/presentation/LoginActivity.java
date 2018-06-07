package nyc.c4q.dogsapp.presentation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import nyc.c4q.dogsapp.R;

public class LoginActivity extends AppCompatActivity {

    public static final String SHARED_PREFS_KEY = "shared preferences key for my dog app";
    public static final String USERNAME_KEY = "key for my username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameInput = findViewById(R.id.username);
        final EditText passwordInput = findViewById(R.id.password);
        Button button = findViewById(R.id.submit);

        // Check if a user is already logged in
        String checkIfUserNamePresent = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)
                .getString(USERNAME_KEY, null);

        if (checkIfUserNamePresent != null) {
            launchDogsActivity();
            finish();
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (username.isEmpty()) {
                    usernameInput.setError(getString(R.string.username_err_msg));
                } else if (password.isEmpty()) {
                    passwordInput.setError(getString(R.string.password_err_msg));
                } else if (password.contains(username)) {
                    passwordInput.setError(getString(R.string.bad_pswrd_err_msg));
                } else {
                    // Save username to SharedPrefs
                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);

//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString(USERNAME_KEY,username);
//                    editor.apply();

                    sharedPreferences.edit()
                            .putString(USERNAME_KEY, username)
                            .apply();

                    launchDogsActivity();
                }
            }
        });
    }

    private void launchDogsActivity() {
//                    Intent intent = new Intent(LoginActivity.this, DogsActivity.class);
//                    startActivity(intent);

        startActivity(new Intent(LoginActivity.this, DogsActivity.class));
    }
}
