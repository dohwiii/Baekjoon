import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int Test = Integer.parseInt(br.readLine());
		int[] num = new int[10001];

		for (int i = 0; i < Test; i++) {
			num[Integer.parseInt(br.readLine())]++;
		}
		br.close();
		
		for (int i = 1; i <10001; i++) // 10
		{
			
			while(num[i]>0)
			{
				sb.append(i).append('\n');
				num[i]--;
				
			}
		}
		System.out.println(sb);
	}
}