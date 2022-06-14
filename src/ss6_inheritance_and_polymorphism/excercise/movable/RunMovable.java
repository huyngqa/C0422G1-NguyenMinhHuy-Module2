package ss6_inheritance_and_polymorphism.excercise.movable;

public class RunMovable {
    public static void main(String[] args) {
        Point point = new MovablePoint();
        MovablePoint movablePoint = (MovablePoint) point;

        movablePoint.setXY(5,4);
        movablePoint.setSpeed(3,3);

        System.out.println("Trước khi di chuyển: " + movablePoint);
        System.out.println("Sau khi di chuyển: " + movablePoint.move());
    }
}
