import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RounDRobin {
    private Queue<Process> queue = new LinkedList<Process>();
    private int QuantmTime;
    private int ContextSwitch;
    private int numOfprocess;
    public RounDRobin(Queue<Process> queue,int QuantmTime,int ContectSwitch,int numOfprocess)
    {
        this.queue = queue;
        this.QuantmTime = QuantmTime;
        this.ContextSwitch = ContextSwitch;
        this.numOfprocess = numOfprocess;
    }
    private ArrayList<Integer> TurnOverTime = new ArrayList<Integer>(numOfprocess);
    private ArrayList<Integer> WitingTime = new ArrayList<Integer>(numOfprocess);
    private ArrayList<String> TurnOverTimeProcessName = new ArrayList<String>(numOfprocess);
    private Queue<Integer> queue_witing = new LinkedList<Integer>();
    void setButestArray()
    {
        for(int i = 0 ; i < numOfprocess;i++)
        {
            Process num = queue.poll();
            queue_witing.add(num.getBurstTime());
            queue.add(num);
        }
    }
    public void algorithm()
    {
        System.out.print("The Process ExecutionOrder Is  : \n");
        int Time =0 ;
        int index = 0;
        this.setButestArray();
        while(!queue.isEmpty())
        {
            Process obj = queue.poll();
            int Temp = 0 ;
            if(!queue_witing.isEmpty())
                Temp = queue_witing.poll();
            if(obj.getBurstTime() >= QuantmTime)
                Time += QuantmTime;
            else
                Time += obj.getBurstTime();

            obj.setBurstTime(obj.getBurstTime()- QuantmTime);
            if(obj.getBurstTime() > 0)
            {
                queue.add(obj);
                queue_witing.add(Temp);
            }
            else
            {
                TurnOverTime.add(index, Time - obj.getArrivarTime());
                TurnOverTimeProcessName.add(index, obj.getName());
                WitingTime.add(index, Time - obj.getArrivarTime() - Temp);
                index++;
            }
            System.out.print(obj.getName() + "\n");
        }
    }
    public void print()
    {
        double sum = 0;
        System.out.print("Turnover Time For Each Process Is : \n");
        for(int i = 0 ; i < TurnOverTime.size() ;i++)
        {
            sum += TurnOverTime.get(i);
            System.out.print(TurnOverTimeProcessName.get(i) + " : "+ TurnOverTime.get(i) +  "\n" );
        }
        System.out.print("Avarage TurnOverTime Is =  " + sum / numOfprocess + " \n");
        sum = 0;
        System.out.print("Waiting Time For Each Process Is : \n");
        for(int i = 0 ; i < TurnOverTime.size() ;i++)
        {
            sum += WitingTime.get(i);
            System.out.print(TurnOverTimeProcessName.get(i) + " : "+ WitingTime.get(i) +  "\n" );

        }
        System.out.print("Avarage WitingTime  Is =  " + sum / numOfprocess +"\n");
    }

}
