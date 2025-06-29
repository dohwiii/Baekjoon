import java.io.*;
import java.util.Arrays;

public class Main {
    static class Student implements Comparable<Student> {
        String name;
        int year, month, day;

        public Student(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public int compareTo(Student s) {
            if (this.year == s.year) {
                if (this.month == s.month) {
                    return this.day - s.day;
                }
                return this.month - s.month;
            }
            return this.year - s.year;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] sArr = new Student[N];

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (String s : arr) {
                sArr[i] = new Student(arr[0], Integer.parseInt(arr[3]), Integer.parseInt(arr[2])
                        , Integer.parseInt(arr[1]));
            }
        }
        Arrays.sort(sArr);
        StringBuilder sb = new StringBuilder();
        sb.append(sArr[N - 1].name + "\n");
        sb.append(sArr[0].name);

        System.out.println(sb);


    }
}