import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static ArrayList<Integer> arr, arr2, idx;

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int Test = Integer.parseInt(br.readLine());
		String[] num = br.readLine().split(" "); //아 한번에 입력받기 위해서 일케 함
		StringBuilder sb= new StringBuilder();
		
		arr=new ArrayList<>();
		arr2=new ArrayList<>();
		idx=new ArrayList<>();
		
		for (int i = 0; i < Test; i++) 
		{
			int a= Integer.parseInt(num[i]);
			arr.add(a);
			idx.add(a);
			
		}
	
		Collections.sort(idx);
		for(int i=0;i<idx.size()-1;i++)
		{
			if(!idx.get(i).equals(idx.get(i+1)))
			{
				arr2.add(idx.get(i));
			}
		}
		arr2.add(idx.get(idx.size()-1));
		
		for(int a:arr)
		{
			int pos=lower_bound(a);
			sb.append(pos+" ");
		}
		System.out.println(sb);
		br.close();
		

	}
	public static int lower_bound(int target)
	{
		int start=0;
		int end=arr2.size()-1;
		
		while(start<end)
		{
			int mid=(start+end)/2;
			if(arr2.get(mid)>=target)
			{
				end=mid;
			}
			else
				start=mid+1;
			
		}
		return end;
		
		
	}

}