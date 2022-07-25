import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner scanner=new Scanner(System.in);
		int N= scanner.nextInt();
		int rank=0;
		
		int[][] arr = new int[N][N];
		
		for(int i=0;i<N;i++)
		{
			arr[i][0]=scanner.nextInt();
			arr[i][1]=scanner.nextInt();
			
		}
		for(int i=0;i<arr.length;i++)
		{
			rank=1;
			
			for(int j=0;j<arr.length;j++)
			{
				if(i==j)
				{
					continue;
				}
				if((arr[i][0]<arr[j][0])&&(arr[i][1]<arr[j][1]))
				{
					rank++;
				}
			}
			System.out.println(rank);
		}
		
	}

}
