package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine()); // 용액 수
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int rigth = N-1;
        int leftIdx = 0;
        int rightIdx = 0;
        int min = Integer.MAX_VALUE;

        while (left < rigth) {
            int mid = arr[left] + arr[rigth];

            if(mid == 0) {
                leftIdx = left;
                rightIdx = rigth;
                break;
            }
            if(Math.abs(mid) < min) {
                min = Math.abs(mid);
                leftIdx = left;
                rightIdx = rigth;
            }
            if(mid < 0) left++;
            else rigth--;
        }

        System.out.println(arr[leftIdx] + " " + arr[rightIdx]);
    }
}
