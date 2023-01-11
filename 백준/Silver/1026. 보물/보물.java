import java.util.*;

public class Main {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++)
        {
            b[i] = sc.nextInt();
        }

        List<Integer> bList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            bList.add(b[i]);
        }
        int ans = 0;

        for (int i = 0; i < n; i++)
        {
            int max = Collections.max(bList);
            ans = ans + (a[i] * max);
            bList.remove(Integer.valueOf(max));
        }
        System.out.println(ans);
    }
}
