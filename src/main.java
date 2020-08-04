import java.util.Scanner;

public class main 
{

	public static void main(String[] args) 
	{
		RRClass rr= new RRClass();
		SPNClass ss= new SPNClass();
		FCFSClass ff= new FCFSClass();

		Scanner scan=new Scanner (System.in);
        
        System.out.println("Enter # of processes");
        int n=scan.nextInt();
        //int n=5;
        
        char [] process=new char [n];
        System.out.println("Enter ur processes names");
        String processString=scan.next();
       
        //double [] arrival=new double [n];
        double [] arrival={0,2,4,6,8};
        //double [] service=new double [n];
        double [] service={3,6,4,5,2};
        //System.out.println("Enter ur arrival time and service time");
        
        for (int i=0;i<n;i++)
        {
            process[i] = processString.charAt(i);
            //System.out.println(process[i]);
            //arrival[i]=scan.nextInt();
            //service[i]=scan.nextInt();
            //System.out.println("\n");
        }
        
        System.out.println("---------------Input---------------");
        for (int i=0;i<n;i++)
            System.out.print(process[i]+"\t");
        System.out.println("\n");
        
        for (int i=0;i<n;i++)
            System.out.print((int)arrival[i]+"\t");
        System.out.println("\n");
        
        for (int i=0;i<n;i++)
            System.out.print((int)service[i]+"\t");
        System.out.println("\n");
        
        int method=0;
        System.out.println("Choose ur SQ method: 1-FCFS  2-SPN  3-RR");
        if (method==1)
            ff.FCFS(n, process, arrival, service);
        else if (method==2)
            ss.SPN(n, process, arrival, service);
        else if (method==3)
        {
            System.out.println("Enter Quantum time");
            int q=scan.nextInt();
            rr.RR(n, process, arrival, service,q);
        }
        //SRT(n,process,arrival,service);
	}

}
