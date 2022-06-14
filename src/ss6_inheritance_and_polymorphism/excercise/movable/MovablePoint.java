package ss6_inheritance_and_polymorphism.excercise.movable;

public class MovablePoint extends Point {
    public float xSpeed;
    public float ySpeed;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] arrays = new float[2];
        arrays[0] = xSpeed;
        arrays[1] = ySpeed;
        return arrays;
    }

    public MovablePoint move() {
        super.setX(getX() + xSpeed);
        super.setY(getY() + xSpeed);
        return this;
    }

    @Override
    public String toString() {
        return "(" + super.getX() + ", " + super.getY() + ")," +
                " speed = (" + xSpeed + ", " + ySpeed + ")\n";
    }
}
