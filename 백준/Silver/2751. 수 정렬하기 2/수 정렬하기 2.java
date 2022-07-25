import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(bf.readLine());

		}
		bf.close();

		Arrays.sort(arr);

		for (int x : arr) {
			bw.write(String.valueOf(x));
			bw.write("\n");
		}
		bw.close();
	}

}