package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14248 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine())-1;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        visited[s] = true;
        int cnt = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            int jump = arr[cur];

            int nx = cur+jump;
            if(nx >= 0 && nx < n && !visited[nx]) {
                visited[nx] = true;
                q.offer(nx);
                cnt++;
            }
            nx = cur-jump;
            if(nx >= 0 && nx < n && !visited[nx]) {
                visited[nx] = true;
                q.offer(nx);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
