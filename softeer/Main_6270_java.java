import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] area = new int[N][2];
        int[][] test = new int[M][2];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            area[i][0] = Integer.parseInt(st.nextToken());
            area[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            test[i][0] = Integer.parseInt(st.nextToken());
            test[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0; // 최대 제한 속도
        int i = 0; // area index
        int j = 0; // test index
        int areaRemain = area[0][0];
        int testRemain = test[0][0];
        
        while(i<N && j<M) {
            // 제한 속도 계산
            int limit = test[j][1] - area[i][1];
            if(limit > 0){
                max = Math.max(max, limit);
            }
            
            if(testRemain < areaRemain) {
                areaRemain -= testRemain;
                j++;
                if(j<M) testRemain = test[j][0];
            } else if (testRemain > areaRemain) {
                testRemain -= areaRemain;
                i++;
                if(i<N) areaRemain = area[i][0];
            } else {
                i++;
                j++;
                if(j<M) testRemain = test[j][0];
                if(i<N) areaRemain = area[i][0];
            }
        }
        
        System.out.println(max);
    }
}
