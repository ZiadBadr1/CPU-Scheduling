import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String []args)
    {
        Queue<Process> queue = new LinkedList<Process>();
        Process p1 = new Process("P1",0,6,5);
        Process p2 = new Process("P2",2,8,5);
        Process p3 = new Process("P3",5,7,5);
        Process p4 = new Process("P4",7,3,5);
        queue.add(p1);
        queue.add(p2);
        queue.add(p3);
        queue.add(p4);
        RounDRobin obj2 = new RounDRobin(queue,2,0,4);
        obj2.algorithm();
        obj2.print();
    }

}
