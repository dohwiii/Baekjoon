import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static char arr[][];
	static int min = 64;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int N = in.nextInt(); // 행
		int M = in.nextInt(); // 열

		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = in.next(); // 한 줄씩

			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}

		} // 입력받기 끝 이차원 배열에 저장함

		for (int i = 0; i < (N - 7); i++) // 전체 비교횟수 (N - 7) * (M - 7)
		{
			for (int j = 0; j < M - 7; j++) {
				find(i, j);
			}

		}
		System.out.println(min);

	}

	public static void find(int x, int y) {
		char color = arr[x][y]; // 왼쪽 맨 위 시작 컬러
		int cnt = 0;

		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if (arr[i][j] != color) {
					cnt++;
				}

				if (color == 'W')
					color = 'B';
				else
					color = 'W';

			}

			if (color == 'W')
				color = 'B';
			else
				color = 'W';

		}

		cnt = Math.min(cnt, 64 - cnt);
		min = Math.min(cnt, min);

	}
}
