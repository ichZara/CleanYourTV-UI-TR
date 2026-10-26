package io.cleanyourtv.ui;

import android.service.dreams.DreamService;

/**
 * The screensaver (set from the computer with `settings put secure screensaver_components`). The system
 * still decides when it starts and when the TV turns off (e.g. after 10 min idle, then 2 h later), as before: the app
 * doesn't change those timings. Any key exits.
 */
public class Screensaver extends DreamService {
    private DreamView dreamView;
    private RainView rainView;

    @Override public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Ui.init(this);
        setInteractive(false);
        setFullscreen(true);
        setScreenBright(true);
        String style = Prefs.screensaverStyle();
        if ("matrix".equals(style)) {
            rainView = new RainView(this);
            setContentView(rainView);
        } else {
            dreamView = new DreamView(this, "aurora".equals(style));
            setContentView(dreamView);
        }
    }

    @Override public void onDreamingStarted() {
        super.onDreamingStarted();
        if (dreamView != null) dreamView.start();
        if (rainView != null) rainView.start();
    }

    @Override public void onDreamingStopped() {
        if (dreamView != null) dreamView.stop();
        if (rainView != null) rainView.stop();
        super.onDreamingStopped();
    }

    @Override public void onDetachedFromWindow() {
        if (dreamView != null) dreamView.stop();
        if (rainView != null) rainView.stop();
        super.onDetachedFromWindow();
    }
}
