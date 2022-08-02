import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int Test = Integer.parseInt(bf.readLine());
		int[] arr = new int[Test];
		int[] check=new int[8001];
		double sum = 0.0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int distance=0;
		int mode_max=0;
		int mode=0;
		boolean flag=false;
		

		
		for(int i=0;i<Test;i++)
		{
			arr[i]=Integer.parseInt(bf.readLine());
			sum+=arr[i];
			check[arr[i]+4000]++;
		}
		Arrays.sort(arr);
		int x=arr.length;
		if(x>1)
		{
			for(int i=0;i<x;i++)
			{
				if(max<arr[i])
				{
					max=arr[i];
				}
				if(min>arr[i])
				{
					min=arr[i];
				}
			}
			distance=max+(-min);
			
			for(int i=min+4000;i<=max+4000;i++)
			{
				if(check[i]>0)
				{
					if(mode_max<check[i])
					{
						mode_max=check[i];
						mode=i-4000;
						flag=true;
					}
					else if(mode_max==check[i]&&flag==true)
					{
						mode=i-4000;
						flag=false;
					}
				}
				
			}
		}
		else
		{
			distance=0;
			mode=arr[0];
		}
		
		
		
		
		System.out.println(Math.round(sum/Test)); //산술평균
		System.out.println(arr[Test/2]); //중앙값
		System.out.println(mode);
		System.out.println(distance);
		

	}
	

}
