package AG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
    static int  Time = 0 ;
    static Process pro = null;
    static double cache = 0;
    public static void non_preemptive(Queue<Process>readyQueue)
    {
        Process tmp = new Process(priority(readyQueue, pro));

        if (tmp.name.equals(pro.name)) {
            double half = Math.ceil(pro.quantum / 2.0) - Math.ceil(pro.quantum / 4.0);
            Time += Math.min(half, pro.burst);
            cache -= half;
            pro.burst -= Math.min(half, pro.burst);
        } else {
            System.out.println("remove " + pro.name + " from the CPU at time: " + Time);
            pro.quantum += Math.ceil(cache / 2.0);
            readyQueue.add(pro);
            pro = new Process(tmp);
            System.out.println(pro.name + " added at time: " + Time);
            cache = pro.quantum;
        }
    }
    public  static boolean SJF(Queue<Process>readyQueue) {
        Process tmp = new Process(Lowest_brust(readyQueue, pro));

        if (tmp.name.equals(pro.name)) {
            cache--;
            pro.burst--;
            return false;
        } else {
            System.out.println("remove " + pro.name + " from the CPU at time: " + Time);
            pro.quantum += cache;
            readyQueue.add(pro);
            pro = new Process(tmp);
            System.out.println(pro.name + " added at time: " + Time);
            cache = pro.quantum;
            return true;
        }
    }
    public static Process priority(Queue<Process> queue, Process p) {
        Queue<Process> process = new LinkedList<>();
        Process hPriority = new Process(p);
        while (queue.size() != 0) {
            Process template = new Process(queue.remove());
            process.add(template);
            if (template.priority < hPriority.priority)
                hPriority = template;
        }
        while (process.size() != 0) {
            Process template = new Process(process.remove());
            if (!template.name.equals(hPriority.name))
                queue.add(template);
        }
        return hPriority;
    }

    public static Process Lowest_brust (Queue<Process> queue, Process p) {
        Queue<Process> list = new LinkedList<>();
        Process process = new Process(p);
        while (queue.size() != 0) {
            Process template = new Process(queue.remove());
            list.add(template);
            if (template.burst < process.burst)
                process = template;
        }
        while (list.size() != 0) {
            Process tmp = new Process(list.remove());
            if (!tmp.name.equals(process.name))
                queue.add(tmp);
        }
        return process;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Process> processes = new LinkedList<>();
        Queue<Integer> w = new LinkedList<>();

        System.out.print("Enter number of process : ");
        int size = input.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter process's name: ");
            String name = input.next();

            System.out.print("Enter arrival time : ");
            int arrival = input.nextInt();
            if (!processes.isEmpty() && arrival < processes.peek().arrival) {
                do {
                    System.out.println("Invalid arrival time");
                    arrival = input.nextInt();
                } while (arrival < processes.peek().arrival);
            }

            System.out.print("Enter burst");
            int burst = input.nextInt();

            System.out.print("Enter priority ");
            int priority = input.nextInt();

            System.out.print("Enter quantum ");
            int quantum = input.nextInt();
            System.out.println(burst );
            System.out.println("");
            Process p = new Process(name, burst, arrival, priority, quantum);
            processes.add(p);
            w.add(burst);
        }

        Queue<Process> readyQueue = new LinkedList<>();


        int waittime = 0 ;
        while (true) {
            if ((processes.isEmpty() && readyQueue.isEmpty()) && pro == null) break;

            while (!processes.isEmpty() && processes.peek().arrival <= Time)
            {
                w.add(processes.peek().burst);
                readyQueue.add(processes.remove());

            }
            if (pro == null && !readyQueue.isEmpty()) {
                pro = readyQueue.remove();
                waittime = w.remove();
                cache = pro.quantum;
                System.out.println(pro.name + " added at time: " + Time);
                continue;
            } else if (pro != null) {
                if (pro.burst == 0) {
                    pro.quantum = 0;
                    System.out.println(pro.name + " Ends at time: " + Time);
                    pro.turndown = Time - pro.arrival ;
                    System.out.println("");
                    System.out.println(pro.name + " turndown " + pro.turndown);
                    //System.out.println("");
                    pro.avgturndown += pro.turndown;

                    pro.wait = Time - pro.arrival - waittime ;
                   // System.out.println("");
                   // System.out.println(Time +" " + pro.arrival + " "+ waittime);
                   // System.out.println("");
                    System.out.println(pro.name + " wait is  " + pro.wait);
                    System.out.println("");
                    pro.avgwait+=pro.wait;

                    pro = null;
                    continue;
                }

                if (cache == 0) {
                    pro.quantum += 2;
                    readyQueue.add(pro);
                    pro = null;
                }

                if (cache == pro.quantum) {
                    Time += Math.min(Math.ceil(pro.quantum / 4.0), pro.burst);
                    cache -= Math.ceil(pro.quantum / 4.0);
                    pro.burst -= Math.min(Math.ceil(pro.quantum / 4.0), pro.burst);
                    continue;
                } else if (cache == pro.quantum - Math.ceil(pro.quantum / 4.0)) {

                    non_preemptive(readyQueue);
                    continue;
                } else if (cache <= pro.quantum - Math.ceil(pro.quantum / 2.0)) {
                    if( SJF(readyQueue))
                        continue;
                }
            }
            Time++;
        }

        System.out.println("avg turndown : " +pro.avgturndown/size);
        System.out.println("avg wait : " +pro.avgwait/size);

    }
}
/*
4
p1
0
17
4
7
p2
2
6
7
9
p3
5
11
3
4
p4
15
4
6
6

 */