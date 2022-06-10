package ss4_class_object_to_java.exercise.quadratic_equation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return (this.b * this.b) - (4 * this.a * this.c);
    }

    public double getRoot1() {
        return ((-this.b) + Math.sqrt(getDiscriminant())) / (2 * this.a);
    }

    public double getRoot2() {
        return ((-this.b) - Math.sqrt(getDiscriminant())) / (2 * this.a);
    }
    public String toString() {
        if (getDiscriminant() > 0) {
            return  "Phương trình có hai nghiệm: x1 = " + getRoot1()
                    + ", x2 = " + getRoot2();
        } else if(getDiscriminant() == 0) {
            return "Phương trình có 1 nghiệm x1 = x2 = " + getRoot1();
        } else {
            return "Phương trình vô nghiệm";
        }
    }
}
