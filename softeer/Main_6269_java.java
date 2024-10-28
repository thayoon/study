import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] secret = new int[M];
        int[] input = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            secret[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        boolean found = false;

        for (int i = 0; i <= N - M; i++) {
            if(input[i] != secret[0]) continue;
            boolean match = true;
            for (int j = 0; j < M; j++) {
                if (input[i + j] != secret[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
    }
}
