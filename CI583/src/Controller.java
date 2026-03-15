import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller{

    private String processID;
    private int burstTime;
    private int priority;

    private static List<String[]> waitingQueue = new ArrayList<>();

    public Controller(String processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    public String getProcessID() {
        return processID;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public List<String[]> getWaitingQueue() {
        return waitingQueue;
    }

//    public static void setWaitingQueue(List<String[]> waitingQueue) {
//        Controller.waitingQueue = waitingQueue;
//    }

    public static void addToWaitingQueue(String[] value) {
        waitingQueue.add(value);
        System.out.println(Arrays.toString(value));
    }

    public void RoundRobin() {

        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " printing: " + i);
            try {
                Thread.sleep(500); // Simulate work with a delay
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }


    }
}
