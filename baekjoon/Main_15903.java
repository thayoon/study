package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> card = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long x = card.poll();
            long y = card.poll();

            card.offer(x+y);
            card.offer(x+y);
        }

        long score = 0;
        while(!card.isEmpty()) {
            score += card.poll();
        }

        System.out.println(score);
    }
}
