package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1)));

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if(now == 0) {
                if(!pq.isEmpty()) {
                    sb.append(pq.poll()).append('\n');
                    continue;
                }
                sb.append(0).append("\n");
            } else {
                pq.offer(now);
            }
        }

        System.out.println(sb);
    }
}
