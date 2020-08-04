import java.text.DecimalFormat;

public class RRClass 
{
	static void RR (int n,char process[], double arrival[], double service[], double quantum)
    {
		resetClass r=new resetClass();
		
        System.out.println("\n");
        System.out.println("---------------------------------RR---------------------------------");
        DecimalFormat df = new DecimalFormat("0.00");
        
        double remaining[] = new double[n]; 
        
        double [] finish=new double [n];
        double [] tr =new double [n];
        double [] TrTs=new double [n];
        double [] stop=new double[process.length];
        
        int totaltime=0;
        for (int i=0;i<n;i++)
            totaltime+=service[i];
        
        for (int i=0;i<process.length;i++)
            stop[i]=1;
        
        char ready[]=new char[totaltime];
        int pointer=0;
        double time=0;
        char curr;
        for (int j=0;j<n;j++)
            remaining[j]=service[j];
                  
        for (int i=0;i<n;i++)
            {
                //System.out.println("");
                if (arrival[i]<=time && remaining[i]!=0)
                {
                    //System.out.println(i+" for process #: "+process[i]+" at time: "+time+" its arrival: "+arrival[i]);
                    ready[pointer]=process[i];
                    pointer++;
                    //System.out.println("pointer: "+pointer);
                }
            }
        int flag=0;
        int index=0;
        int done=0;
        int sum1=0;
        double sum2=0;
        while (done==0)
        {
            curr=ready[0]; //de-queue 1st
            //System.out.println("curr: "+curr);
            
            if(pointer>1)
            r.reset(ready,pointer);
            
            pointer--;
            
            //System.out.println("1st: "+curr+" pointer: "+pointer);
            for (int j=0;j<n;j++)
            {
                if (process[j]==curr)
                {
                    //for each process
                    if (remaining[j]>quantum)
                    {
                        //System.out.println("remaining: "+remaining[j]);
                        remaining[j]=remaining[j]-quantum;
                        time=time+quantum;
                        //System.out.println("new remaining: "+remaining[j]+" new time: "+time);
                    }

                    else //lw el process =0 lw el quantum =1
                    {
                        time=time+remaining[j];
                        remaining[j]=0;
                        //System.out.println("finished process: "+process[j]+"at time: "+time);
                        stop[index]=0;
                        index++;
                        finish[j]=time;
                        tr[j]=finish[j]-arrival[j];
                        TrTs[j]=tr[j]/service[j];
                        sum1+=tr[j];
                        sum2+=TrTs[j];
                    }
                    
                for (int i=j+1;i<n;i++) //ashof fi 7aga b3dy gat wlaa la
                {
                    if (arrival[i]<=time && remaining[i]!=0)
                    {
                        flag=1;
                        for(int z=0;z<pointer;z++)
                        {
                            if (process[i]==ready[z])
                                flag=0;
                        }
                        if (flag==1)
                        {
                            //System.out.println(i+" for process #: "+process[i]+" at time: "+time+" its arrival: "+arrival[i]);
                            ready[pointer]=process[i];
                            pointer++;
                            //System.out.println("pointer: "+pointer);
                        }
                        
                    }
                }
                
                if (remaining[j]!=0)
                {
                    ready[pointer]=curr;
                    //System.out.println("put back: "+ready[pointer]);
                    pointer++;
                }
                
                }
            } 
            done=1;
            for (int m=0;m<stop.length;m++)
            {
                if (stop[m]!=0)
                    done=0;
            }
        }
        
        System.out.println("------------RR  Output-----------");
        
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
        
            System.out.println("------------RR  Mean-----------");
            System.out.println("Tr mean = "+df.format(sum1/n));
            System.out.println("Tr/Ts mean = "+df.format(sum2/n));
    }
}
