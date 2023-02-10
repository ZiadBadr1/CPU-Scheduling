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
            System.out.println("Enter the Priority of "+p.ProcessName+" :");
            p.processPriority=sc.nextInt();
            processes.add(p);
        }
        Preemie_Priority Priority=new Preemie_Priority(processes);
        Priority.start();
    }
}
