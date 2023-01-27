import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++)
        {
            long find = arr[i];
            int start = 0;
            int end = n - 1;

            while (start < end)
            {
                if (arr[start] + arr[end] == find)
                {
                    if (start != i && end != i) {
                        count++;
                        break;
                    } else if (start == i) {
                        start++;

                    } else if (end == i) {
                        end--;
                    }

                }
                else if(arr[start] + arr[end] < find)
                {
                    start++;

                }
                else
                {
                    end--;
                }
            }
        }

        System.out.println(count);


    }
}
