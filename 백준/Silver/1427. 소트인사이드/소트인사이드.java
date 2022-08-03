import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		
		String str= sc.next();
		List<Character> list =new ArrayList<Character>();
		
		for(int i=0;i<str.length();i++)
		{
			list.add(str.charAt(i));
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(char x : list)
		{
			System.out.print(x);
		}

	}

}
