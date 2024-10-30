import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken()); // 자동차 개수
        int q = Integer.parseInt(st.nextToken()); // 질의 수

        int[] arr = new int[n]; // 연비
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0; i<q; i++) {
            int m = Integer.parseInt(br.readLine());
            int index = Arrays.binarySearch(arr, m); // m의 인덱스 찾기
            if(index <= 0) { // 인덱스가 0이거나 없는 경우
                sb.append(0).append("\n");
            } else {
                int result = index*(n-1-index); // 경우의 수 구하기
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
