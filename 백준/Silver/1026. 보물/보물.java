
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a=new int[N];
		int[] b=new int[N];
		int sum=0;
		
		for(int i=0;i<N;i++)
		{
			a[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++)
		{
			b[i]=sc.nextInt();
		}
		Integer[] aArr=Arrays.stream(a).boxed().toArray(Integer[]::new);
		
		Arrays.sort(aArr, Collections.reverseOrder());
		Arrays.sort(b);
		
		int[] aOriginal=Arrays.stream(aArr).mapToInt(Integer::intValue).toArray();
		
		for(int i=0;i<N;i++)
		{
			sum+=aOriginal[i]*b[i];
		}
		System.out.println(sum);
		
		

	}

}