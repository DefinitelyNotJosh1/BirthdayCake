package cs301.birthdaycake;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class Balloon {
    private float centerX;
    private float centerY;
    Paint balloonColor = new Paint();
    Paint gray = new Paint();

    public Balloon(float x, float y) {
        centerX = x;
        centerY = y;
        balloonColor.setColor(0xFF42A7F5); // light blue
        gray.setColor(0xFF898989); // gray
    }

    public void drawBalloon(Canvas canvas) {
        canvas.drawRect(centerX - 5.0f, centerY, centerX + 5.0f, centerY + 100.0f, gray);
        canvas.drawOval(centerX - 70.0f, centerY - 90.0f, centerX + 70.0f,
                     centerY + 60.0f, balloonColor);

        Path triangle = new Path();
        triangle.moveTo(centerX, centerY);
        triangle.lineTo(centerX - 15.0f, centerY + 70.0f);
        triangle.lineTo(centerX + 15.0f, centerY + 70.0f);
        canvas.drawPath(triangle, balloonColor);
    }
}