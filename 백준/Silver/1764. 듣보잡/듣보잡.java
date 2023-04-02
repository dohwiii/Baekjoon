import java.io.*;
import java.util.*;

public class Main
{
    static int N, M;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++)
        {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < M; i++)
        {
            String str = br.readLine();
            if (map.containsKey(str))
            {
                list.add(str);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (String str : list)
        {
            System.out.println(str);
        }
        br.close();
    }
}