import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int start = 0;
        int end = arr.length - 1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        while (start < end)
        {
            if (arr[start] + arr[end] == m)
            {
                count++;
                start++;
                end--;

            }
            else if(arr[start] + arr[end] < m)
            {
                start++;

            }
            else
            {
                end--;
            }
        }
        System.out.println(count);


    }
}
