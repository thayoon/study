package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819 {
    static int N, max;
    static int[] arr, A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        A = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);

        System.out.println(max);
    }

    public static void perm(int cnt) {
        if (cnt == N) {
            int sum = 0;
            for (int i = 0; i < N-1; i++) {
                sum += Math.abs(A[i]-A[i+1]);
            }
            max = Math.max(max, sum);

            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                A[cnt] = arr[i];
                perm(cnt+1);
                visited[i] = false;
            }
        }
    }
}
