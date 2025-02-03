package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] train = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());
            int seat = 0;
            switch (oper) {
                case 1:
                    seat = Integer.parseInt(st.nextToken())-1;
                    train[line] |= 1<<seat;
                    break;
                case 2:
                    seat = Integer.parseInt(st.nextToken())-1;
                    train[line] &= ~(1<<seat);
                    break;
                case 3:
                    train[line] <<= 1;
                    train[line] &= ((1<<20)-1);
                    break;
                case 4:
                    train[line] >>= 1;
                    break;
            }
        }
        Set<Integer> galaxy = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            galaxy.add(train[i]);
        }

        System.out.println(galaxy.size());
    }
}
