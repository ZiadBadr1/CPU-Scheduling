import java.util.*;

public class Process implements Comparable<Process> {
    public String ProcessName;
    public int arrivalTime;
    public int burstTime;
    public int processPriority;
    public boolean inQueue=false;
    public int wating=0;
    public int turndown=0;
    public boolean done=false;
    public Process(){}
    public int compareTo(Process p){
        return Integer.compare(burstTime,p.burstTime);
    }
}
