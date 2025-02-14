package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] line = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        int x = line[0][0];
        int y = line[0][1];
        int len = y-x;
        for (int i = 1; i < N; i++) {
            if(line[i][1] < y) continue;
            if(line[i][0] >= y) {
                len += line[i][1] - line[i][0];
            } else if(line[i][0] < y && y < line[i][1]) {
                len += line[i][1] - y;
            }
            y = line[i][1];
        }

        System.out.println(len);
    }
}
