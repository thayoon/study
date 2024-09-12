package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10974 {
    static int[] num;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        num = new int[N];
        visited = new boolean[N];

        perm(0, N);
    }

    private static void perm(int cnt, int n) {
        StringBuilder sb = new StringBuilder();

        if(cnt == n) {
            for (int number : num) {
                sb.append(number).append(" ");
            }
            System.out.println(sb);
        } else {
            for (int i = 1; i <= n; i++) {
                if(visited[i-1]) continue;
                else {
                    num[cnt] = i;
                    visited[i-1] = true;

                    perm(cnt+1, n);

                    visited[i-1] = false;
                }
            }
        }
    }
}
