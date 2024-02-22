package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        //Reference cakeView object
        CakeView cakeView = findViewById(R.id.cakeview);

        //create CakeController
        CakeController cakeController = new CakeController(cakeView, this);

        //retrieve reference to "Blow Out" button
        Button blowOutButton = findViewById(R.id.blowOutButton);

        //connect controller to object
        blowOutButton.setOnClickListener(cakeController);

        //retrieve reference to "Candles" switch
        Switch candlesSwitch = findViewById(R.id.candleSwitch);

        //connect controller to object
        candlesSwitch.setOnCheckedChangeListener(cakeController);

        //retrieve reference to "How many candles?" Seekbar
        SeekBar candlesSeekBar = findViewById(R.id.candleSeekBar);

        //connect controller to object
        candlesSeekBar.setOnSeekBarChangeListener(cakeController);

        cakeView.setOnTouchListener(cakeController);

    }

    public void goodbye(View button) {
        Log.i("button","Goodbye");
    }
}
