package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20117 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        // {4, 2, 8, 9} -> ({2, 8}, {4, 9})
        int max = 0;
        if(N%2 == 0) {
            for (int i = N/2; i < N; i++) {
                max += arr[i]*2;
            }
        } else {
            max += arr[N/2];
            for (int i = N/2+1; i < N; i++) {
                max += arr[i]*2;
            }
        }

        System.out.println(max);
    }
}
