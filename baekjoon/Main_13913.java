package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        int[] path = new int[100001];
        Arrays.fill(time, -1);
        Queue<Integer> q = new ArrayDeque<>();
        time[N] = 0;
        path[N] = -1;
        q.offer(N);

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == K) break;

            for (int next : new int[] {cur-1, cur+1, 2*cur}) {
                if(next >= 0 && next <= 100000 && time[next] == -1) {
                    q.offer(next);
                    time[next] = time[cur]+1;
                    path[next] = cur;
                }
            }
        }

        sb.append(time[K]).append("\n");
        Stack<Integer> s = new Stack<>();
        int cnt = K;
        while(cnt != -1) {
            s.push(cnt);
            cnt = path[cnt];
        }
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
