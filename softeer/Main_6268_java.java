import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int TC = Integer.parseInt(br.readLine());
        boolean[][] switchs = {
            {true, true, true, true, true, true, false}, // 0
            {false, true, true, false, false, false, false}, // 1
            {true, true, false, true, true, false, true}, // 2
            {true, true, true, true, false, false, true}, // 3
            {false, true, true, false, false, true, true}, // 4
            {true, false, true, true, false, true, true}, // 5
            {true, false, true, true, true, true, true}, // 6
            {true, true, true, false, false, true, false}, // 7
            {true, true, true, true, true, true, true}, // 8
            {true, true, true, true, false, true, true}, // 9
        };
        
        for(int i=0; i<TC; i++) {
            st = new StringTokenizer(br.readLine());
            String prev = st.nextToken();
            String now = st.nextToken();
            
            // 5자리로 자릿수 맞추기
            prev = "nnnnn".substring(prev.length()) + prev;
            now = "nnnnn".substring(now.length()) + now; 
            
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                char p = prev.charAt(j); // 이전 숫자 자리
                char n = now.charAt(j);  // 현재 숫자 자리
                if(p=='n' && n=='n') continue; // switch off
                else if(p!='n' && n=='n') { // prev on now off
                    for (int k = 0; k < 7; k++) {
                        if (switchs[p-'0'][k]) {
                            cnt++;
                        }
                    }
                }else if(p=='n' && n!='n') { // prev off now on
                    for (int k = 0; k < 7; k++) {
                        if (switchs[n-'0'][k]) {
                            cnt++;
                        }
                    }
                } else { // prev on now on
                    for (int k = 0; k < 7; k++) {
                        if (switchs[p-'0'][k] != switchs[n-'0'][k]) {
                            cnt++;
                        }
                    }   
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
