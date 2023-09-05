package com.safonov.speedreading.training.fragment.concentration.training.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;
import javax.vecmath.Vector2d;

public class MovingCircle {
    private static final int BORDER_COEFFICENT = 7;
    private Paint answerPaint;
    private int border;
    private final int mass = 10;
    private Paint paint;
    private Vector2d position;
    private int radius;
    private Vector2d speed;

    public MovingCircle(Vector2d position2, Vector2d speed2, int radius2) {
        this.position = position2;
        this.radius = radius2;
        this.speed = speed2;
        this.border = radius2 / 7;
    }

    public void setNextPos() {
        this.position.f146x += this.speed.f146x;
        this.position.f147y += this.speed.f147y;
    }

    public boolean isOnWallX(int width) {
        if (this.position.f146x - ((double) this.radius) < Utils.DOUBLE_EPSILON || this.position.f146x + ((double) this.radius) > ((double) width)) {
            return true;
        }
        return false;
    }

    public boolean isOnWallY(int height) {
        if (this.position.f147y - ((double) this.radius) < Utils.DOUBLE_EPSILON || this.position.f147y + ((double) this.radius) > ((double) height)) {
            return true;
        }
        return false;
    }

    public void setWallPosX(int width) {
        if (this.position.f146x - ((double) this.radius) < Utils.DOUBLE_EPSILON) {
            this.position.f146x = (double) this.radius;
        } else {
            this.position.f146x = (double) (width - this.radius);
        }
        setOppositeSpeedX();
    }

    public void setOppositeSpeedX() {
        this.speed.f146x *= -1.0d;
    }

    public void setWallPosY(int height) {
        if (this.position.f147y - ((double) this.radius) < Utils.DOUBLE_EPSILON) {
            this.position.f147y = (double) this.radius;
        } else {
            this.position.f147y = (double) (height - this.radius);
        }
        setOppositeSpeedY();
    }

    public void setOppositeSpeedY() {
        this.speed.f147y *= -1.0d;
    }

    public boolean isCollisionWithCircle(MovingCircle circle) {
        if (getDistance(circle.getPosition().f146x, circle.getPosition().f147y) <= getSumRadius(circle)) {
            return true;
        }
        return false;
    }

    public void collisionWithCircle(MovingCircle circle) {
        double xDist = this.position.f146x - circle.getPosition().f146x;
        double yDist = this.position.f147y - circle.getPosition().f147y;
        double distSquared = (xDist * xDist) + (yDist * yDist);
        double dotProduct = (xDist * (circle.getSpeed().f146x - this.speed.f146x)) + (yDist * (circle.getSpeed().f147y - this.speed.f147y));
        if (dotProduct > Utils.DOUBLE_EPSILON) {
            double collisionScale = dotProduct / distSquared;
            double xCollision = xDist * collisionScale;
            double yCollision = yDist * collisionScale;
            getClass();
            double combinedMass = (double) (circle.getMass() + 10);
            double collisionWeightA = ((double) (circle.getMass() * 2)) / combinedMass;
            getClass();
            double collisionWeightB = ((double) 20) / combinedMass;
            this.speed.f146x += collisionWeightA * xCollision;
            this.speed.f147y += collisionWeightA * yCollision;
            circle.speed.f146x -= collisionWeightB * xCollision;
            circle.speed.f147y -= collisionWeightB * yCollision;
        }
    }

    public boolean collisionWithWalls(int width, int height) {
        if (isOnWallY(height)) {
            setWallPosY(height);
            return true;
        } else if (!isOnWallX(width)) {
            return false;
        } else {
            setWallPosX(width);
            return true;
        }
    }

    private double getDistance(double x, double y) {
        return Math.hypot(this.position.f146x - x, this.position.f147y - y);
    }

    private double getSumRadius(MovingCircle circle) {
        return (double) (this.radius + circle.getRadius());
    }

    public int getMass() {
        return 10;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius2) {
        this.radius = radius2;
        this.border = radius2 / 7;
    }

    public MovingCircle() {
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public void setPosition(Vector2d position2) {
        this.position = position2;
    }

    public Vector2d getSpeed() {
        return this.speed;
    }

    public void setSpeed(Vector2d speed2) {
        this.speed = speed2;
    }

    public Paint getAnswerPaint() {
        return this.answerPaint;
    }

    public void setAnswerPaint(Paint answerPaint2) {
        this.answerPaint = answerPaint2;
    }

    public Paint getPaint() {
        return this.paint;
    }

    public void setPaint(Paint paint2) {
        this.paint = paint2;
    }

    public boolean isPointIn(double x, double y) {
        if (getDistance(x, y) <= ((double) this.radius)) {
            return true;
        }
        return false;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float) this.position.f146x, (float) this.position.f147y, (float) (this.radius - this.border), this.paint);
    }

    public void draw(Canvas canvas, Paint paint2) {
        canvas.drawCircle((float) this.position.f146x, (float) this.position.f147y, (float) (this.radius - this.border), paint2);
    }

    public void drawAnswered(Canvas canvas) {
        canvas.drawCircle((float) this.position.f146x, (float) this.position.f147y, (float) (this.radius - this.border), this.answerPaint);
    }

    public void setPosOutCircle(MovingCircle circle, int width, int height) {
        double x;
        double y;
        if (circle.getPosition().f146x >= this.position.f146x && getPosForCircleRight(circle) >= ((double) width)) {
            x = getPosForCircleLeft(circle);
        } else if (circle.getPosition().f146x >= this.position.f146x && getPosForCircleRight(circle) < ((double) width)) {
            x = getPosForCircleRight(circle);
        } else if (circle.getPosition().f146x >= this.position.f146x || getPosForCircleLeft(circle) > Utils.DOUBLE_EPSILON) {
            x = getPosForCircleLeft(circle);
        } else {
            x = getPosForCircleRight(circle);
        }
        if (circle.getPosition().f147y >= this.position.f147y && getPosForCircleBottom(circle) >= ((double) height)) {
            y = getPosForCircleTop(circle);
        } else if (circle.getPosition().f147y >= this.position.f147y && getPosForCircleBottom(circle) < ((double) height)) {
            y = getPosForCircleBottom(circle);
        } else if (circle.getPosition().f147y >= this.position.f147y || getPosForCircleTop(circle) > Utils.DOUBLE_EPSILON) {
            y = getPosForCircleTop(circle);
        } else {
            y = getPosForCircleBottom(circle);
        }
        circle.setPosition(new Vector2d(x, y));
    }

    private double getPosForCircleLeft(MovingCircle circle) {
        return ((this.position.f146x - ((double) circle.getRadius())) - ((double) this.radius)) - ((double) this.border);
    }

    private double getPosForCircleRight(MovingCircle circle) {
        return this.position.f146x + ((double) circle.getRadius()) + ((double) this.radius) + ((double) this.border);
    }

    private double getPosForCircleTop(MovingCircle circle) {
        return ((this.position.f147y - ((double) circle.getRadius())) - ((double) this.radius)) - ((double) this.border);
    }

    private double getPosForCircleBottom(MovingCircle circle) {
        return this.position.f147y + ((double) circle.getRadius()) + ((double) this.radius) + ((double) this.border);
    }
}
