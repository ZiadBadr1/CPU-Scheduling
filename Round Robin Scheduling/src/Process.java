public class Process {
    private String Name;
    private int ArrivarTime;
    private int BurstTime;
    private int priority;
    public Process(String Name,int ArrivarTime,int BurstTime,int priority)
    {
        this.Name = Name;
        this.ArrivarTime = ArrivarTime;
        this.BurstTime = BurstTime;
        this.priority = priority;
    }
    public void setNme(String Name)
    {
        this.Name = Name;
    }
    public void setBurstTime(int BurstTime)
    {
        this.BurstTime = BurstTime;
    }
    public void setpriority(int priority)
    {
        this.priority = priority;
    }
    public String getName()
    {
        return this.Name;
    }
    public int getArrivarTime()
    {
        return this.ArrivarTime;
    }
    public int getBurstTime()
    {
        return this.BurstTime;
    }
    public int getpriority()
    {
        return this.priority;
    }



}
