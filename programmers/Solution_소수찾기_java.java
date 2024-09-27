import java.util.*;

class Solution {
    static int N, num[];
    static boolean visited[];
    static TreeSet<Integer> prime = new TreeSet<>();  // 소수 TreeSet
    
    public int solution(String numbers) {
        N = numbers.length();   // numbers 길이
        num = new int[N];   // 종이 조각
        visited = new boolean[N];
        
        for(int i=0; i<N; i++) {
            num[i] = numbers.charAt(i) - '0';
        }
        
        for(int i=1; i<=N; i++) {
            perm(0, i, "");    // 숫자 만들기
        }
        
        return prime.size();
    }
    
    private static void perm(int cnt, int r, String cur) {
        // bc
        if(cnt == r) {
            // 소수 판별
            int num = Integer.parseInt(cur);
            if(isPrime(num)){
                prime.add(num);
            }
            
            return;
        }
        // 순열
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                perm(cnt+1, r, cur+num[i]);
                visited[i] = false;
            }
        }
    }
    
    private static boolean isPrime(int n) {
        if(n<2) return false;
        for(int i=2; i*i <= n; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
}