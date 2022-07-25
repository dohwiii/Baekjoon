import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		List<Person> arr = new ArrayList<>();
		int[] count = new int[N];

		for (int i = 0; i < N; i++) {

			int a = in.nextInt();
			int b = in.nextInt();
			arr.add(new Person(a, b));
		}

		for (int i = 0; i < N - 1; i++) {
			Person p = arr.get(i);

			for (int j = i + 1; j < N; j++) {
				if (p.compareTo(arr.get(j)) == -1) {
					count[i]++;
				} else if (p.compareTo(arr.get(j)) == 1) {
					count[j]++;
				}
			}

		}
		for (int i = 0; i < N; i++) {
			System.out.print(count[i] + 1 + " ");
		}

	}
}

class Person implements Comparable<Person> {
	int weight;
	int height;

	Person(int x, int y) {
		this.weight = x;
		this.height = y;
	}

	@Override
	public int compareTo(Person p) {
		if (this.weight < p.weight & this.height < p.height) {
			return -1;
		} else if (this.weight > p.weight & this.height > p.height) {
			return 1;
			// 양수가 나오면 자리바꿈 해야함
		} else
			return 0;

	}

}
