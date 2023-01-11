import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            int x = Integer.parseInt(bf.readLine());
            for (int j = 0; j < x; j++)
            {
                System.out.print("=");

            }
            System.out.println();

        }
    }
}