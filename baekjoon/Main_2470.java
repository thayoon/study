package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine()); // 용액 수
        int[] arr = new int[N]; // 특성값

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        int min = 2000000001; // 두 용액의 혼합 최소값
        int[] ans = new int[2]; // 답 배열
        while (left<right) {
            int mix = arr[left]+arr[right]; // 혼합 특성값

            if (mix == 0) { // 0 이라면 답 갱신, while문 종료
                ans[0] = arr[left];
                ans[1] = arr[right];
                break;
            }
            if(Math.abs(mix) < min) { // 최소값 갱신
                min = Math.abs(mix);
                ans[0] = arr[left];
                ans[1] = arr[right];
            }

            if(mix < 0) { // 혼합 특성값이 음수라면 다음으로 작은 용액
                left+=1;
            }else { // 양수라면 다음으로 큰 용액
                right-=1;
            }
        }

        System.out.println(ans[0]+" "+ans[1]);
    }
}
