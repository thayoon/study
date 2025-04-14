package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // f(D) = a[D]*A + b[D]*B = K
        int[] a = new int[D+1]; // A
        int[] b = new int[D+1]; // B

        a[1] = 1; b[1] = 0;
        a[2] = 0; b[2] = 1;

        for (int i = 3; i <= D; i++) {
            a[i] = a[i-1] + a[i-2];
            b[i] = b[i-1] + b[i-2];
        }

        // x == A, y == B (1<=A<=B)
        for (int x = 1; x <= K; x++) {
            int y = K-a[D]*x;
            if(y%b[D] != 0) continue;

            y /= b[D];
            if(x <= y) {
                System.out.println(x);
                System.out.println(y);
                break;
            }
        }
    }
}
