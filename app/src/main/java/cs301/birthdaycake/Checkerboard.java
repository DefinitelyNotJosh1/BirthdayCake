package cs301.birthdaycake;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Checkerboard {
    protected float x;
    protected float y;
    protected int size = 80;
    protected Paint greenPaint = new Paint();
    protected Paint redPaint = new Paint();

    public Checkerboard(float initX, float initY) {
        x = initX;
        y = initY;
        greenPaint.setColor(0xFF00FF00);
        redPaint.setColor(0xFFFF0000);

    }

    //draw checkerboard
    public void draw(Canvas canvas) {
        canvas.drawRect(x - size, y - size, x, y,greenPaint);
        canvas.drawRect(x, y - size, x + size, y, redPaint);
        canvas.drawRect(x, y, x + size, y + size,greenPaint);
        canvas.drawRect(x - size, y, x, y + size, redPaint);
    }


}
