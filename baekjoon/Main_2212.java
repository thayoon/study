package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine()); // 센서 개수
        int K = Integer.parseInt(br.readLine()); // 집중국 개수
        int[] sensor = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        int[] dif = new int[N-1]; // 각 센서 거리 차이
        for (int i = 0; i < N-1; i++) {
            dif[i] = sensor[i+1] - sensor[i];
        }
        Arrays.sort(dif);

        int min = 0;
        for (int i = 0; i < N-K; i++) {
            // N개의 센서와 K개의 집중국이 있다면 N-K개 만큼의 연결 구간 필요
            min += dif[i];
        }

        System.out.println(min);
    }
}
