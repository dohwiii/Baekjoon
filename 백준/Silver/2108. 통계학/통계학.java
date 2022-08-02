import java.util.Arrays;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] freq = new int[8001];

		for (int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		System.out.println(avg(arr, N));
		System.out.println(arr[Math.round(N / 2)]);

		int max = 0;
		for (int i = 0; i < N; i++)
		{
			freq[arr[i] + 4000]++;
			max = Math.max(max, freq[arr[i] + 4000]);
		}

		int second = 0; // 두 번쨰로 작은 값 저장 변수
		int count = 0;

		for (int i = 0; i < freq.length; i++)
		{
			if (freq[i] == max)
			{
				count++;
				second = i - 4000;
			}
			// 최빈값이 두 개 이상일 경우 두 번째로 작은 값을 찾아 저장한다.
			if (count == 2)
			{
				second = i - 4000;
				break;
			}
		}

		System.out.println(second);
		System.out.println(range(arr));
	}

	public static int avg(int[] arr, int N)
	{
		int sum = 0;

		for (int i = 0; i < arr.length; i++)
		{
			sum = sum + arr[i];
		}
		if (sum < 0)
			return (int) ((sum / (double) N) - 0.5);
		else
			return (int) ((sum / (double) N) + 0.5);
	}

	public static int range(int[] arr)
	{
		Arrays.sort(arr);
		int max = arr[arr.length - 1];
		int min = arr[0];

		return Math.abs(max - min);
	}

}
