import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[] dx = {1, -1, 0, 0}; //남, 북, 동, 서
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //보드 크기
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        game(0);
        System.out.println(result);
    }

    public static void game(int count) {
        if (count == 5) {
            int max = Arrays.stream(board)
                    .flatMapToInt(Arrays::stream)
                    .max().orElseThrow();
            if (result < max) {
                result = max;
            }
            return;
        }
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = board[i].clone();
        }
        for (int i = 0; i < 4; i++) {
            move(i);
            game(count + 1);
            //백트래킹을 위한 원복
            for (int j = 0; j < N; j++) {
                board[j] = copy[j].clone();
            }
        }
    }

    public static void move(int dir) {
        switch (dir) {
            case 0: //남
                for (int i = 0; i < N; i++) {
                    int block = 0;
                    int index = N - 1;
                    for (int j = N - 1; j >= 0; j--) {

                        if (board[j][i] != 0) //블록이 있을 때
                        {
                            if (block == board[j][i]) {
                                board[index + 1][i] = block * 2;
                                board[j][i] = 0;
                                block = 0;

                            } else if (block != board[j][i]) {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index--;
                            }
                        }

                    }
                }
                break;
            case 1: //북
                for (int i = 0; i < N; i++) {
                    int block = 0;
                    int index = 0;
                    for (int j = 0; j < N; j++) {

                        if (board[j][i] != 0) //블록이 있을 때
                        {
                            if (block == board[j][i]) {
                                board[index - 1][i] = block * 2;
                                board[j][i] = 0;
                                block = 0;

                            } else if (block != board[j][i]) {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index++;
                            }
                        }

                    }
                }
                break;
            case 2: //동
                for (int i = 0; i < N; i++) {
                    int block = 0;
                    int index = N - 1; //블록 다음 인덱스

                    for (int j = N - 1; j >= 0; j--) {
                        if (board[i][j] != 0) {
                            if (board[i][j] == block) //블록과 같은 크기라면
                            {
                                board[i][index + 1] = block * 2;
                                board[i][j] = 0;
                                block = 0;
                            } else if (board[i][j] != block) {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case 3: //서
                for (int i = 0; i < N; i++) {
                    int block = 0;
                    int index = 0; //블록 다음 인덱스

                    for (int j = 0; j < N; j++) {
                        if (board[i][j] != 0) {
                            if (board[i][j] == block) //블록과 같은 크기라면
                            {
                                board[i][index - 1] = block * 2;
                                board[i][j] = 0;
                                block = 0;
                            } else if (board[i][j] != block) {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
        }
    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}