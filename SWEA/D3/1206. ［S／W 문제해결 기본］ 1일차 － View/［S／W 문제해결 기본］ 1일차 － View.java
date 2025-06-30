import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{	
        Scanner sc = new Scanner(System.in);
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n=sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
            	arr[i]=sc.nextInt();
            }
            
            int answer=0;
            
            for(int curr=2; curr<n-2; curr++){
            	int max=Integer.MIN_VALUE;
                for(int j=curr-2; j<curr; j++) max=(max<arr[j])?arr[j]:max;
                for(int j=curr+1; j<curr+3; j++) max=(max<arr[j])?arr[j]:max;
                
                if(arr[curr]-max>0) answer+=arr[curr]-max;
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}