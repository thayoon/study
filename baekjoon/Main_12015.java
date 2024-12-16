package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] LIS = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = A[0];
        int len = 1;

        for (int i = 1; i < N; i++) {
            if(LIS[len-1] < A[i]) {
                len++;
                LIS[len - 1] = A[i]; // 추가
            } else {
                int low = 0;
                int high = len;

                while (low < high) {
                    int mid = (low+high) / 2;

                    if(LIS[mid] < A[i]) {
                        low = mid+1;
                    } else {
                        high = mid;
                    }
                }

                LIS[low] = A[i]; // 대체
            }
        }

        System.out.println(len);
    }
}
