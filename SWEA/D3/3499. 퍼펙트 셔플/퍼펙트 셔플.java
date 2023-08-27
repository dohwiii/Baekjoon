import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{
    static int N;
    static String[] cards;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++)
        {
            N = Integer.parseInt(br.readLine()); //카드 수
            cards = new String[N]; //카드

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
            {
                cards[i] = st.nextToken();
            }
            int halfN = cards.length / 2;

            //포인터
            int p1 = 0;
            int p2 = cards.length - halfN;
            sb.append("#" + (t + 1) + " ");

            while (p1 < cards.length - halfN)
            {
                sb.append(cards[p1] + " ");
                p1++;

                if (p2 <= N - 1)
                {
                    sb.append(cards[p2] + " ");
                    p2++;
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }


}
