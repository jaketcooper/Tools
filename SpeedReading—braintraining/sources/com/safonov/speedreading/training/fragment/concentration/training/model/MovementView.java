package com.safonov.speedreading.training.fragment.concentration.training.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.safonov.speedreading.training.fragment.concentration.repository.IConcentrationRepository;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationConfig;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationResult;
import com.safonov.speedreading.training.fragment.concentration.training.view.IConcentrationView;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.vecmath.Vector2d;

@SuppressLint({"ViewConstructor"})
public class MovementView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    public static final int CIRCLES_GRAY_RUN_TIME = 2000;
    public static final int CIRCLES_RUN_TIME = 4000;
    public static final int FPS = 60;
    public static final int ONE_TICK = 10;
    public static final int SHOW_ANSWER = 1500;
    public static final int SHOW_ANSWER_DELAY = 150;
    private int answersCount = 0;
    private Paint circlePaintBlue = new Paint();
    private Paint circlePaintGrey = new Paint();
    private Paint circlePaintRed = new Paint();
    /* access modifiers changed from: private */
    public List<MovingCircle> circles;
    /* access modifiers changed from: private */
    public int colorGreen = getResources().getColor(R.color.accept_green);
    private int colorRed = getResources().getColor(R.color.reject_red);
    /* access modifiers changed from: private */
    public ConcentrationConfig config;
    /* access modifiers changed from: private */
    public int correctAnswers = 0;
    private int correctGameCount = 0;
    private boolean correction = true;
    /* access modifiers changed from: private */
    public int currentGameCount = 0;
    /* access modifiers changed from: private */
    public Level currentLevel;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    private int height;
    private int inCorrectGameCount = 0;
    /* access modifiers changed from: private */
    public boolean isAllGrey = false;
    /* access modifiers changed from: private */
    public boolean isAnswered = false;
    /* access modifiers changed from: private */
    public boolean isAuto;
    /* access modifiers changed from: private */
    public boolean isLocked = false;
    private boolean isRun = false;
    /* access modifiers changed from: private */
    public IConcentrationRepository repository;
    /* access modifiers changed from: private */
    public Runnable restartLevel = new Runnable() {
        public void run() {
            boolean unused = MovementView.this.isLocked = false;
            if (MovementView.this.isAuto) {
                MovementView.this.view.hidePointsTextView();
                MovementView.access$1208(MovementView.this);
                MovementView.this.getNextLevel(false);
                if (MovementView.this.currentGameCount >= 20) {
                    ConcentrationResult result = new ConcentrationResult();
                    result.setScore(MovementView.this.currentLevel.getScore());
                    MovementView.this.repository.addResult(result, MovementView.this.config.getId(), new IConcentrationRepository.OnSingleTransactionCallback() {
                        public void onTransactionCompleted(int id) {
                            MovementView.this.view.onConcentrationTrainingCompleted(id);
                        }
                    });
                    return;
                }
            }
            MovementView.this.startLevel();
        }
    };
    private int score = 0;
    private Runnable showCorrectAnswer = new Runnable() {
        public void run() {
            if (MovementView.this.isAuto) {
                MovementView.this.view.setPointsTextViewCorrect(MovementView.this.correctAnswers);
            }
            Paint correctPaint = new Paint();
            correctPaint.setColor(MovementView.this.colorGreen);
            for (MovingCircle circle : MovementView.this.circles) {
                if (circle.getPaint().getColor() == -16776961) {
                    circle.setPaint(correctPaint);
                }
            }
            boolean unused = MovementView.this.isAnswered = false;
            MovementView.this.drawToScreen();
            MovementView.this.handler.postDelayed(MovementView.this.startNextLevel, 1500);
        }
    };
    private Runnable showInCorrectAnswer = new Runnable() {
        public void run() {
            boolean unused = MovementView.this.isAllGrey = false;
            boolean unused2 = MovementView.this.isAnswered = true;
            Paint correctPaint = new Paint();
            correctPaint.setColor(MovementView.this.colorGreen);
            for (MovingCircle circle : MovementView.this.circles) {
                if (circle.getPaint().getColor() == -16776961 && circle.getAnswerPaint().getColor() != -16776961) {
                    circle.setAnswerPaint(correctPaint);
                }
            }
            MovementView.this.drawToScreen();
            if (MovementView.this.isAuto) {
                MovementView.this.view.setPointsTextViewCorrect(MovementView.this.correctAnswers);
            }
            MovementView.this.handler.postDelayed(MovementView.this.restartLevel, 1500);
        }
    };
    /* access modifiers changed from: private */
    public Runnable startNextLevel = new Runnable() {
        public void run() {
            boolean unused = MovementView.this.isLocked = false;
            if (MovementView.this.isAuto) {
                MovementView.this.view.hidePointsTextView();
                MovementView.access$1208(MovementView.this);
                MovementView.this.getNextLevel(true);
                if (MovementView.this.currentGameCount >= 20) {
                    ConcentrationResult result = new ConcentrationResult();
                    result.setScore(MovementView.this.currentLevel.getScore());
                    MovementView.this.repository.addResult(result, MovementView.this.config.getId(), new IConcentrationRepository.OnSingleTransactionCallback() {
                        public void onTransactionCompleted(int id) {
                            MovementView.this.view.onConcentrationTrainingCompleted(id);
                        }
                    });
                    return;
                }
            }
            MovementView.this.startLevel();
        }
    };
    private Thread thread = new Thread(this);
    private long time;
    private CountDownTimer timerAll;
    private CountDownTimer timerGray;
    /* access modifiers changed from: private */
    public IConcentrationView view;
    private int width;
    private int wrongAnswers = 0;

    static /* synthetic */ int access$1208(MovementView x0) {
        int i = x0.currentGameCount;
        x0.currentGameCount = i + 1;
        return i;
    }

    public MovementView(Context context, IConcentrationRepository repository2, int configId, IConcentrationView view2, boolean isPause) {
        super(context);
        getHolder().addCallback(this);
        this.repository = repository2;
        this.config = repository2.getConfig(configId);
        this.circlePaintGrey.setColor(-7829368);
        this.circlePaintBlue.setColor(-16776961);
        this.circlePaintRed.setColor(this.colorRed);
        this.currentLevel = new Level(this.config.getCirclesCount(), this.config.getCirclesCount() / 2, this.config.getCirclesRadius(), this.config.getCirclesSpeed());
        Log.d("count", "" + this.config.getCirclesRadius());
        ConcentrationResult bestResult = repository2.getBestResult(configId);
        view2.initProgressBar(20);
        view2.updateScoreView(0);
        view2.updateProgressBar(0);
        view2.updateBestScoreView(bestResult == null ? 0 : bestResult.getScore());
        this.view = view2;
        if (this.currentLevel.getCircleCount() >= 12 && this.correction) {
            this.currentLevel.setCircleRadius(this.currentLevel.getCircleRadius() - (this.currentLevel.getCircleRadius() / 5));
            this.correction = false;
        } else if (this.currentLevel.getCircleCount() < 12) {
            this.currentLevel.setCircleRadius(this.config.getCirclesRadius());
        }
        this.isAuto = true;
        if (isPause) {
            this.isRun = false;
        } else {
            this.isRun = true;
        }
    }

    public MovementView(Context context, int circlesCount, int circlesSpeed, int circlesRadius, boolean isPause) {
        super(context);
        getHolder().addCallback(this);
        this.circlePaintGrey.setColor(-7829368);
        this.circlePaintBlue.setColor(-16776961);
        this.circlePaintRed.setColor(this.colorRed);
        this.currentLevel = new Level(circlesCount, circlesCount / 2, circlesRadius, circlesSpeed);
        if (this.currentLevel.getCircleCount() >= 16 && this.correction) {
            this.currentLevel.setCircleRadius(this.currentLevel.getCircleRadius() - (this.currentLevel.getCircleRadius() / 5));
            this.correction = false;
        }
        this.isAuto = false;
        if (isPause) {
            this.isRun = false;
        } else {
            this.isRun = true;
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(getResources().getColor(R.color.colorBackground));
        for (MovingCircle circle : this.circles) {
            if (this.isAllGrey) {
                circle.draw(canvas, this.circlePaintGrey);
            } else if (this.isAnswered) {
                circle.drawAnswered(canvas);
            } else {
                circle.draw(canvas);
            }
        }
    }

    public void updatePhysics() {
        int size = this.circles.size();
        for (MovingCircle circle : this.circles) {
            circle.setNextPos();
        }
        for (int i = 0; i < size; i++) {
            MovingCircle firstCircle = this.circles.get(i);
            for (int j = i + 1; j < size; j++) {
                MovingCircle secondCircle = this.circles.get(j);
                if (firstCircle.isCollisionWithCircle(secondCircle)) {
                    firstCircle.collisionWithCircle(secondCircle);
                }
            }
            firstCircle.collisionWithWalls(this.width, this.height);
        }
    }

    public void surfaceCreated(SurfaceHolder holder) {
        Rect surfaceFrame = holder.getSurfaceFrame();
        this.width = surfaceFrame.width();
        this.height = surfaceFrame.height();
        this.circles = initCircles(this.currentLevel);
        drawToScreen();
        startThread();
    }

    public void startThread() {
        startTimerToAllGrey(4000);
        this.thread = new Thread(this);
        this.thread.start();
    }

    private void startTimerToAllGrey(long time2) {
        this.timerAll = new CountDownTimer(time2, 10) {
            public void onTick(long millisUntilDone) {
            }

            public void onFinish() {
                MovementView.this.showAllGrey();
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void showAllGrey() {
        this.isAllGrey = true;
        startTimerStop(2000);
    }

    private void startTimerStop(long time2) {
        this.timerGray = new CountDownTimer(time2, 10) {
            public void onTick(long millisUntilDone) {
            }

            public void onFinish() {
                MovementView.this.stopGame();
            }
        }.start();
    }

    public void stopGame() {
        this.isAllGrey = true;
        this.isRun = false;
        boolean retry = true;
        while (retry) {
            try {
                this.thread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        drawToScreen();
    }

    /* access modifiers changed from: private */
    public void drawToScreen() {
        Canvas canvas = null;
        try {
            canvas = getHolder().lockCanvas((Rect) null);
        } finally {
            if (canvas != null) {
                draw(canvas);
                getHolder().unlockCanvasAndPost(canvas);
            }
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width2, int height2) {
    }

    public void cancelGame() {
        this.isRun = false;
        boolean retry = true;
        while (retry) {
            try {
                this.thread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.handler.removeCallbacks(this.showCorrectAnswer);
        this.handler.removeCallbacks(this.showInCorrectAnswer);
        this.handler.removeCallbacks(this.restartLevel);
        this.handler.removeCallbacks(this.startNextLevel);
        if (this.timerAll != null) {
            this.timerAll.cancel();
        }
        if (this.timerGray != null) {
            this.timerGray.cancel();
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        cancelGame();
    }

    private List<MovingCircle> initCircles(Level level) {
        List<MovingCircle> result = new ArrayList<>();
        Random random = new Random();
        int bufferBlue = level.getCircleCountTrue();
        for (int i = 0; i < level.getCircleCount(); i++) {
            if (bufferBlue > 0) {
                result.add(createCircle(level.getCircleRadius(), level.getCircleSpeed(), this.circlePaintBlue, random));
                bufferBlue--;
            } else {
                result.add(createCircle(level.getCircleRadius(), level.getCircleSpeed(), this.circlePaintGrey, random));
            }
        }
        int size = result.size();
        for (int i2 = 0; i2 < size; i2++) {
            MovingCircle firstCircle = result.get(i2);
            for (int j = 0; j < size; j++) {
                if (i2 != j) {
                    MovingCircle secondCircle = result.get(j);
                    if (firstCircle.isCollisionWithCircle(secondCircle)) {
                        firstCircle.setPosOutCircle(secondCircle, this.width, this.height);
                    }
                }
            }
            firstCircle.collisionWithWalls(this.width, this.height);
        }
        return result;
    }

    private MovingCircle createCircle(int radius, int speed, Paint paint, Random random) {
        MovingCircle result = new MovingCircle();
        result.setRadius(radius);
        result.setPosition(new Vector2d((double) (random.nextInt(this.width) + radius), (double) (random.nextInt(this.height) + radius)));
        result.setSpeed(new Vector2d((double) speed, (double) speed));
        result.setPaint(paint);
        return result;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 0 && !this.isRun && !this.isLocked) {
            performClick();
            checkTouchCircles((double) event.getX(), (double) event.getY());
            drawToScreen();
            if (this.answersCount == this.currentLevel.getCircleCountTrue()) {
                this.isLocked = true;
                if (this.correctAnswers == this.currentLevel.getCircleCountTrue()) {
                    this.handler.postDelayed(this.showCorrectAnswer, 150);
                    this.correctGameCount++;
                    this.inCorrectGameCount = 0;
                }
                if (this.wrongAnswers > 0) {
                    this.handler.postDelayed(this.showInCorrectAnswer, 150);
                    this.correctGameCount = 0;
                    this.inCorrectGameCount++;
                }
            }
        }
        return false;
    }

    public boolean performClick() {
        return super.performClick();
    }

    /* access modifiers changed from: private */
    public void getNextLevel(boolean isCorrectAnswered) {
        if (this.isAuto) {
            this.view.updateProgressBar(this.currentGameCount);
            this.view.updateScoreView(this.currentLevel.getScore());
            if (!isCorrectAnswered || this.currentLevel.getCircleCount() >= 12) {
                this.currentLevel.setCircleSpeed(this.config.getCirclesSpeed());
            } else {
                this.currentLevel.setCircleSpeed(this.currentLevel.getCircleSpeed() + 2);
            }
            if (isCorrectAnswered && this.correctGameCount == 3) {
                this.currentLevel.setCircleSpeed(this.config.getCirclesSpeed());
                this.currentLevel.setCircleCount(this.currentLevel.getCircleCount() + 2);
                this.currentLevel.setCircleCountTrue(this.currentLevel.getCircleCountTrue() + 1);
                this.correctGameCount = 0;
                this.inCorrectGameCount = 0;
                this.repository.updateConfig(this.config.getId(), this.currentLevel.getCircleCount(), this.config.getCirclesRadius(), this.currentLevel.getCircleSpeed());
            } else if (this.inCorrectGameCount == 3 && this.currentLevel.getCircleCount() > 4) {
                this.currentLevel.setCircleSpeed(this.config.getCirclesSpeed());
                this.currentLevel.setCircleCount(this.currentLevel.getCircleCount() - 2);
                this.currentLevel.setCircleCountTrue(this.currentLevel.getCircleCountTrue() - 1);
                this.correctGameCount = 0;
                this.inCorrectGameCount = 0;
                this.repository.updateConfig(this.config.getId(), this.currentLevel.getCircleCount(), this.config.getCirclesRadius(), this.currentLevel.getCircleSpeed());
            }
            if (this.currentLevel.getCircleCount() >= 12 && this.correction) {
                this.currentLevel.setCircleRadius(this.currentLevel.getCircleRadius() - (this.currentLevel.getCircleRadius() / 5));
                this.correction = false;
            } else if (this.currentLevel.getCircleCount() < 12) {
                this.currentLevel.setCircleRadius(this.config.getCirclesRadius());
            }
        }
    }

    public void startLevel() {
        this.circles = initCircles(this.currentLevel);
        this.isRun = true;
        this.wrongAnswers = 0;
        this.correctAnswers = 0;
        this.answersCount = 0;
        this.isAnswered = false;
        this.isAllGrey = false;
        startThread();
    }

    private void checkTouchCircles(double x, double y) {
        for (MovingCircle circle : this.circles) {
            if ((circle.isPointIn(x, y) && circle.getAnswerPaint() == null) || (circle.isPointIn(x, y) && circle.getAnswerPaint().getColor() == -7829368)) {
                this.answersCount++;
                if (circle.getPaint().getColor() == -16776961) {
                    circle.setAnswerPaint(circle.getPaint());
                    this.correctAnswers++;
                    this.currentLevel.setScore(this.currentLevel.getScore() + 1);
                } else {
                    circle.setAnswerPaint(this.circlePaintRed);
                    this.wrongAnswers++;
                }
            } else if (circle.getAnswerPaint() == null) {
                circle.setAnswerPaint(this.circlePaintGrey);
            }
        }
        this.isAllGrey = false;
        this.isAnswered = true;
    }

    public void run() {
        while (this.isRun) {
            long cTime = System.currentTimeMillis();
            if (cTime - this.time <= 16) {
                updatePhysics();
                drawToScreen();
            }
            this.time = cTime;
        }
    }
}
