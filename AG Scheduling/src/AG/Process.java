package AG;

public class Process {
    public String name;
    public int burst, arrival, priority, quantum , wait = 0 , turndown = 0 ;
    public int remain  ;
    public static float avgturndown = 0 , avgwait = 0 ;

    public Process(String name, int burst, int arrival, int priority, int quantum) {
        this.name = name;
        this.burst = burst;
        this.arrival = arrival;
        this.priority = priority;
        this.quantum = quantum;
        this.remain = this.burst ;
    }
    public Process(Process p)
    {
        this.name = p.name;
        this.burst = p.burst;
        this.arrival = p.arrival;
        this.priority =p. priority;
        this.quantum =p. quantum;
        this.remain = p.burst ;

    }
}