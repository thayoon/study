package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18442 {
    static int V, P;
    static long L, min;
    static long[] map, visited, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());
        min = Long.MAX_VALUE;
        map = new long[V];
        visited = new long[P];
        ans = new long[P];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++) {
            map[i] = Long.parseLong(st.nextToken());
        }

        comb(0, 0);

        sb.append(min).append("\n");
        for (int i = 0; i < P; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void comb(int cnt, int start) {
        if(cnt == P) {
            long len = 0;
            for (int i = 0; i < V; i++) {
                long minLen = Long.MAX_VALUE;
                for (int j = 0; j < P; j++) {
                    minLen = Math.min(Math.min(Math.abs(map[i]-visited[j]), L-Math.abs(map[i]-visited[j])), minLen);
                }
                len += minLen;
            }

            if(min > len) {
                min = len;
                ans = visited.clone();
            }
            return;
        }

        for (int i = start; i < V; i++) {
            visited[cnt] = map[i];
            comb(cnt+1, i+1);
        }
    }
}
