package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    private CakeView cakeView;
    private CakeModel cakeModel;
    private MainActivity mainActivity;

    public CakeController(CakeView ck, MainActivity ma) {
        cakeView = ck;
        cakeModel = cakeView.getCakeModel();
        mainActivity = ma;
    }

    @Override
    public void onClick(View v) {
        Button b = mainActivity.findViewById(R.id.blowOutButton);
        if (cakeModel.candlesLit) {
            cakeModel.candlesLit = false;
            b.setText("Re-Light");
        }
        else {
            cakeModel.candlesLit = true;
            b.setText("Extinguish");
        }

        cakeView.invalidate();
    }
    /** whenever the user touches the surface view */

    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        String c = Float.toString(x) + ","+ Float.toString(y);


        cakeModel.cords = c;
        cakeView.invalidate();

        return false;

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (!isChecked) {
            cakeModel.candles = false;
        }
        if (isChecked) {
            cakeModel.candles = true;
        }
        cakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        cakeModel.numCandles = progress;
        cakeView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        cakeView.balloon = new Balloon(x, y);
        cakeView.invalidate();

        return false;
    }
}
