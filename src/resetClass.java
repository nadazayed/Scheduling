
public class resetClass 
{
	static void reset(char ready[],int pointer)
    {
        //System.out.println("Q before");
//        for (int i=0;i<pointer;i++)
//            System.out.print(ready[i]+"\t");
        
//        System.out.println("\n Q after");
        
        for (int i=1;i<pointer;i++)
        {
            ready[i-1]=ready[i];
        } 
        
//        for (int i=0;i<pointer-1;i++)
//            System.out.print(ready[i]+"\t");
//        System.out.println("");
        
    }
}
