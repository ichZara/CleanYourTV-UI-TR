package io.cleanyourtv.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.Choreographer;
import android.view.View;

import java.util.Random;

/**
 * Matrix-style digital rain screensaver. Columns of mirrored katakana and digits falling down the screen.
 */
public final class RainView extends View implements Choreographer.FrameCallback {
    private static final long FRAME_NS = 50_000_000L; // 20 fps
    private static final int TRAIL = 0xFF00FF41;
    private static final int HEAD = 0xFFD8FFD8;
    private static final int DROPS_PER_COLUMN = 2;
    private static final String GLYPHS;

    static {
        StringBuilder b = new StringBuilder();
        for (char c = 'ｦ'; c <= 'ﾝ'; c++) b.append(c);
        b.append("0123456789Z:.=*+-<>¦");
        GLYPHS = b.toString();
    }

    private final Random random = new Random();
    private final Paint glyph = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint fade = new Paint();
    private final Paint clear = new Paint();
    private Bitmap frame;
    private Canvas canvas;
    private float cell;
    private int columns;
    private float[] row;
    private float[] speed;
    private int[] lastRow;
    private char[] lastGlyph;
    private boolean running;
    private long lastFrame;

    public RainView(Context context) {
        super(context);
        setBackgroundColor(0xFF000000);
        glyph.setTypeface(Typeface.MONOSPACE);
        glyph.setTextAlign(Paint.Align.CENTER);
        fade.setColor(0x16000000);
        clear.setColor(0xFF000000);
    }

    public void start() {
        if (running) return;
        running = true;
        lastFrame = 0;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        running = false;
        Choreographer.getInstance().removeFrameCallback(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w == 0 || h == 0) return;
        cell = 14 * getResources().getDisplayMetrics().density;
        glyph.setTextSize(cell * 0.92f);
        if (frame != null && !frame.isRecycled()) frame.recycle();
        frame = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(frame);
        canvas.drawColor(0xFF000000);
        columns = (int) Math.ceil(w / cell);
        int drops = columns * DROPS_PER_COLUMN;
        row = new float[drops];
        speed = new float[drops];
        lastRow = new int[drops];
        lastGlyph = new char[drops];
        int rows = (int) (h / cell);
        for (int c = 0; c < drops; c++) {
            row[c] = -random.nextInt(Math.max(1, rows * DROPS_PER_COLUMN));
            speed[c] = newSpeed();
            lastRow[c] = -1;
        }
    }

    @Override
    public void doFrame(long now) {
        if (!running) return;
        if (canvas != null && now - lastFrame >= FRAME_NS) {
            lastFrame = now;
            step();
            invalidate();
        }
        Choreographer.getInstance().postFrameCallback(this);
    }

    private float newSpeed() {
        return 0.35f + random.nextFloat() * 0.65f;
    }

    private void step() {
        if (canvas == null || frame == null) return;
        canvas.drawRect(0, 0, frame.getWidth(), frame.getHeight(), fade);
        int rows = (int) (frame.getHeight() / cell) + 1;
        for (int c = 0; c < row.length; c++) {
            row[c] += speed[c];
            int r = (int) Math.floor(row[c]);
            if (r == lastRow[c]) continue;
            if (lastRow[c] >= 0) draw(c % columns, lastRow[c], lastGlyph[c], TRAIL);
            if (r >= rows) {
                row[c] = -random.nextInt(Math.max(1, rows / 3 + 1));
                speed[c] = newSpeed();
                lastRow[c] = -1;
                continue;
            }
            if (r >= 0) {
                char g = GLYPHS.charAt(random.nextInt(GLYPHS.length()));
                draw(c % columns, r, g, HEAD);
                lastRow[c] = r;
                lastGlyph[c] = g;
            }
        }
        for (int i = 0; i < row.length / 6; i++) {
            int c = random.nextInt(row.length);
            int r = lastRow[c] - 1 - random.nextInt(12);
            if (r >= 0) draw(c % columns, r, GLYPHS.charAt(random.nextInt(GLYPHS.length())), TRAIL & 0x99FFFFFF);
        }
    }

    private void draw(int column, int r, char g, int colour) {
        float left = column * cell;
        float top = r * cell;
        canvas.drawRect(left, top, left + cell, top + cell, clear);
        glyph.setColor(colour);
        float cx = left + cell / 2;
        canvas.save();
        canvas.scale(-1, 1, cx, 0);
        canvas.drawText(String.valueOf(g), cx, top + cell * 0.85f, glyph);
        canvas.restore();
    }

    @Override
    protected void onDraw(Canvas c) {
        if (frame != null) c.drawBitmap(frame, 0, 0, null);
    }
}
