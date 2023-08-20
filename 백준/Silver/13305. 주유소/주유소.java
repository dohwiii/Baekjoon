import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //도시 개수
        int minMoney = 0; //최소금액
        int[] distances = new int[N - 1];
        int[] oilMoney = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Integer.parseInt(st.nextToken()); //도시 길이
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            oilMoney[i] = Integer.parseInt(st.nextToken()); //리터당 가격
        }
        int money = 0;
        int nowOilMoney = oilMoney[0];
        for (int i = 0; i < N - 1; i++) {
            int dis = distances[i]; //현재 도로 거리

            //현재 오일가격 * 거리 < 다음 오일 가격 * 거리
            if (nowOilMoney > oilMoney[i]) {
                nowOilMoney = oilMoney[i];
            }
            money += nowOilMoney * dis;

        }
        System.out.println(money);

    }
}