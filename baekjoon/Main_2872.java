package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] book = new int[N];

        for (int i = 0; i < N; i++) {
            book[i] = Integer.parseInt(br.readLine());
        }

        int num = N;
        for (int i = N-1; i >= 0; i--) {
            if(book[i] == num) num--;
        }

        System.out.println(num);
    }
}
