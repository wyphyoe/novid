package software.techbase.novid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import software.techbase.novid.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(this::goToNextScreen, 1000);
    }

    private void goToNextScreen() {

        this.startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }
}
