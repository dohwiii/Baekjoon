import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
		int M = in.nextInt();
		int max= Integer.MIN_VALUE;
		
		int[] arr= new int[N];
 
		for(int i=0;i<N;i++)
		{
			arr[i]=in.nextInt();
		}
		
		for(int i=0;i<N-2;i++)
		{
			for(int j=i+1; j<N-1;j++)
			{
				for(int k=j+1;k<N;k++)
				{
					if(arr[i]+arr[j]+arr[k]<=M)
					{
						if(max<arr[i]+arr[j]+arr[k])
						{
							max=arr[i]+arr[j]+arr[k];
						}
					}
					
				}
			}
		}
		System.out.println(max);
 
	}
 
 
}