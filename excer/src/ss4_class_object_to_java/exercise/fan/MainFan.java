package ss4_class_object_to_java.exercise.fan;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println(fan1.toString());

        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5);
        System.out.println(fan2.toString());
    }
}
