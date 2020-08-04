import java.text.DecimalFormat;

public class SPNClass 
{
    static void SPN (int n, char []process, double []arrival, double []service)
    {
        System.out.println("\n");
        System.out.println("---------------------------------SPN---------------------------------");
        DecimalFormat df = new DecimalFormat("0.00");
        
        //new arrays
        double [] finish=new double [n];
        double [] tr =new double [n];
        double [] TrTs=new double [n];
        char [] name=new char[n];
        double [] arrival_new=new double [n];
        double [] service_new= new double[n];
        
        double tr_avg, TrTs_avg;
        double sum1=0,sum2=0;
        double start=arrival[0];
        
        
        double time=0,min;
        int pointer=0,curr=0;
        double [] temp=new double[n];
        
        ////
        for (int i=0;i<n;i++)
        {
            //System.out.println("\n");
            //System.out.println("Slot #: "+i+"  at time: "+time);
            pointer=0;
            
            for (int j=0;j<n;j++) //bshooof min wsl till now
            {
                if (arrival[j]<=time && arrival[j]>-1)
                {
                    //System.out.println("Found: "+process[j] +"  arrival:"+arrival[j] + "  pointer: "+pointer);
                    temp[pointer]=service[j];
                    pointer++;
                    curr=j;
                }
            }
            //System.out.println("curr: "+curr);
            
            if (pointer>1)
            {
                //System.out.println("Entered >1");
                min=temp[0];
            for (int j=1;j<pointer;j++)
            {
                if (temp[j]<min) //extract el minimum
                    min=temp[j];
            }
            
            //System.out.println("Minimum service: "+min);
            
            for (int j=0;j<n;j++)
            {
                if (service[j]==min)
                {
                    //System.out.println("name: "+process[j]+" service: "+service[j]);
                    if (arrival[j]>start)
                        start=arrival[j];
                    
                    name[i]=process[j];
                    finish[i]=start+service[j];
                    tr[i]=(start-arrival[j])+service[j];
                    sum1+=tr[i];
                    TrTs[i]=tr[i]/service[j];
                    sum2+=TrTs[i];
                    service_new[i]=service[j];
                    arrival_new[i]=arrival[j];
                    
                    
                    //System.out.println("OLD");
                    //System.out.println("name: "+name[i]+"  arrive: "+arrival_new[i]+"  Start: "+start+"  finish: "+finish[i]+"  tr: "+tr[i]+"  trts: "+TrTs[i]);
                    
                    time=finish[i];
                    start=finish[i];
                    
                    arrival[j]=arrival[j]+1;
                    arrival[j]=arrival[j]*-1;
                    //System.out.println("arrival j again: "+arrival[j]);
                    
                    
                    //System.out.println("NEW");
                    //System.out.println("name: "+process[j]+"  arrive: "+arrival[j]);
                }
            }
            }
            
            
            else
            {
                //System.out.println("Entered =1");
            if (arrival[curr]>start)
                start=arrival[curr];
            
            name[i]=process[curr];
            finish[i]=start+service[curr];
            tr[i]=(start-arrival[curr])+service[curr];
            sum1+=tr[i];
            TrTs[i]=tr[i]/service[curr];
            sum2+=TrTs[i];
            service_new[i]=service[curr];
            arrival_new[i]=arrival[curr];
            
            //System.out.println("name: "+name[i]+"  arrive: "+arrival_new[i]+"  Start: "+start+"  finish: "+finish[i]+"  tr: "+tr[i]+"  trts: "+TrTs[i]);
            
            time=finish[i];
            start=finish[i];
            arrival[i]=arrival[i]+1;
            arrival[i]=arrival[i]*-1;
            
            //System.out.println("NEW");
            //System.out.println("name: "+name[i]+"  arrive: "+arrival[i]);
            }
            
        }
        
        System.out.println("------------SPN  Output-----------");
        
        for (int x=0;x<n;x++)
            System.out.print(name[x]+"\t");
        System.out.println("\n");
        
        for (int x=0;x<n;x++)
            System.out.print((int)arrival_new[x]+"\t");
        System.out.println("\n");
        
        for (int x=0;x<n;x++)
            System.out.print((int)service_new[x]+"\t");
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
        
            System.out.println("------------SPN  Mean-----------");
            System.out.println("Tr mean = "+df.format(sum1/n));
            System.out.println("Tr/Ts mean = "+df.format(sum2/n));
            
        System.out.println("\n");
    }
}
