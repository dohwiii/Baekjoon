import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 도시 개수
        int M = Integer.parseInt(br.readLine());    // 버스 개수
        int[][] cityFare = new int[N][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cityFare[a - 1][b - 1] = cityFare[a - 1][b - 1] != 0 ? Math.min(cityFare[a - 1][b - 1], c) : c;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (cityFare[i][k] > 0 && cityFare[k][j] > 0) {
                        if (cityFare[i][j] != 0) {
                            cityFare[i][j] = Math.min(cityFare[i][j], cityFare[i][k] + cityFare[k][j]);
                        } else {
                            cityFare[i][j] = cityFare[i][k] + cityFare[k][j];
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(cityFare[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static class City implements Comparable<City> {
        int city, fare;

        public City(int city, int fare) {
            this.city = city;
            this.fare = fare;
        }

        @Override
        public int compareTo(City o) {
            return this.fare - o.fare;
        }
    }

}