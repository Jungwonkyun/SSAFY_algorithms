package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BlackFriday {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        HashSet<Integer> hs = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        
        //1개로 가능한지 확인
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            hs.add(cur);
            if (cur == c) {
                System.out.println(1);
                return;
            }
        }
        
        //2개로 가능한지 확인
        for (int i = 0; i < n; i++) {
            int remain = c-arr[i];
            if (arr[i] == remain) continue;
            if (hs.contains(remain)) {
                System.out.println(1);
                return;
            }
        }               
        
        //3개로 가능한지 확인
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int remain = c-(arr[i]+arr[j]);
                
                //같은 무게는 들어있지 않으니까
                if (remain == arr[i] || remain == arr[j]) continue;
                if (hs.contains(remain)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}



