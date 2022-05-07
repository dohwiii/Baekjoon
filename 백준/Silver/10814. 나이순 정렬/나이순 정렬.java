import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();

		Info[] info = new Info[size];

		for (int i = 0; i < size; i++) {
			info[i] = new Info(sc.nextInt(), sc.next());
		}
		Arrays.sort(info, new Comparator<Info>() {

			public int compare(Info i1, Info i2) {
				return i1.age - i2.age;
			}
		});

		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<size;i++)
		{
			sb.append(info[i]);
		}
		System.out.println(sb);
	}
}

class Info {
	int age;
	String name;

	public Info(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public String toString()
	{
		return age+" "+name+"\n";
	}
}

