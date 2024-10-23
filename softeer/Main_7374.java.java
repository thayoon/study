import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] arr = new int[3][3];
        int cost = Integer.MAX_VALUE;
        
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<3; i++) {
            if((arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) || (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i])) {
                cost = 0;
                break;
            }
            else {
                int rCenter = arr[i][0] + arr[i][1] + arr[i][2] - Math.min(arr[i][0], Math.min(arr[i][1], arr[i][2])) - Math.max(arr[i][0], Math.max(arr[i][1], arr[i][2]));
                int cCenter = arr[0][i] + arr[1][i] + arr[2][i] - Math.min(arr[0][i], Math.min(arr[1][i], arr[2][i])) - Math.max(arr[0][i], Math.max(arr[1][i], arr[2][i]));
                
                int row = Math.abs(rCenter-arr[i][0]) + Math.abs(rCenter-arr[i][1]) + Math.abs(rCenter-arr[i][2]);
                int col = Math.abs(cCenter-arr[0][i]) + Math.abs(cCenter-arr[1][i]) + Math.abs(cCenter-arr[2][i]);
                
                cost = Math.min(cost, Math.min(row, col));
            }
        }

        System.out.println(cost);
    }
}
