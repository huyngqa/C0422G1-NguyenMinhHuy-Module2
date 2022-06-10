package ss4_class_object_to_java.exercise.strop_watch;

public class MainStopWatch {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Thời gian bắt đầu thực thi: " + stopWatch.getStartTime());
        long sum = 0;
        for (long i = 0; i < 1000000000; i++) {
            sum += i;
        }
        System.out.println("Tổng là: " + sum);
        stopWatch.stop();
        System.out.println("Thời gian kết thúc thực thi: " + stopWatch.getEndTime());
        System.out.println("Thuật toán thực thi hết: "
                + stopWatch.getElapsedTime() + "mili giây");
    }
}
