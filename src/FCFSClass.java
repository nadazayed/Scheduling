import java.text.DecimalFormat;

public class FCFSClass 
{
    static void FCFS (int n, char []process, double []arrival, double []service)
    {
        System.out.println("\n");
        System.out.println("---------------------------------FCFS---------------------------------");
        DecimalFormat df = new DecimalFormat("0.00");
        double [] finish=new double [n];
        double [] tr =new double [n];
        double [] TrTs=new double [n];
        double tr_avg, TrTs_avg;
        double sum1=0,sum2=0;
        double start=arrival[0];
        for (int i=0;i<n;i++)
        {
            //System.out.println("for process: "+process[i]);
            
            if (arrival[i]>start)
                start=arrival[i];
            
            //System.out.println("arrived at: "+arrival[i]+" started at: "+start+" with service: "+service[i]);
            
            finish[i]=start+service[i];
            //System.out.println("finished at: "+finish[i]);
            
            tr[i]=(start-arrival[i])+service[i];
            //System.out.println("start-arrival : "+(start-arrival[i])+" tr: "+tr[i]);
            sum1+=tr[i];
            TrTs[i]=tr[i]/service[i];
            //System.out.println("TrTs: "+TrTs[i]);
            sum2+=TrTs[i];
            
            start=finish[i];
        }
        
        System.out.println("------------FCFS  Output-----------");
        for (int x=0;x<n;x++)
            System.out.print(process[x]+"\t");
        System.out.println("\n");
        
        for (int x=0;x<n;x++)
            System.out.print((int)arrival[x]+"\t");
        System.out.println("\n");
        
        for (int x=0;x<n;x++)
            System.out.print((int)service[x]+"\t");
        System.out.println("\n");
        
        for (int x=0;x<n;x++)
            System.out.print((int)finish[x]+"\t");
        System.out.println("\n");
        
        for (int x=0;x<n;x++)
            System.out.print((int)tr[x]+"\t");
        System.out.println("\n");
        
        for (int x=0;x<n;x++)
            System.out.print(df.format(TrTs[x])+"\t");
        System.out.println("\n");
        
        
        
        
        System.out.println("------------FCFS  Mean-----------");
            System.out.println("Tr mean = "+df.format(sum1/n));
            System.out.println("Tr/Ts mean = "+df.format(sum2/n));
            
        System.out.println("\n");
    }
}
