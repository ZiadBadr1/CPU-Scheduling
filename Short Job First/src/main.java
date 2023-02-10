import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n;
        n=sc.nextInt();
        ArrayList<Process>processes=new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.println("Enter the process name: ");
            Process p=new Process();
            p.ProcessName=sc.next();
            System.out.println("Enter the burst time of "+p.ProcessName+" :");
            p.burstTime=sc.nextInt();
            System.out.println("Enter the arrival time of "+p.ProcessName+" :");
            p.arrivalTime=sc.nextInt();
            processes.add(p);
        }
        SJF sjf=new SJF(processes);
        sjf.start();
    }
}
/*
7
p1
3
0
p2
5
2
p3
4
1
p4
2
4
p5
9
6
p6
4
5
p7
10
7
 */