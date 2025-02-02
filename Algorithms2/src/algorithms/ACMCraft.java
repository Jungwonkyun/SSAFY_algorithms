package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ACMCraft {
	static int TC, N, K, W;
	static int[] building;
	static int[] inNode;
	static ArrayList<ArrayList<Integer>> Adjacent;
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer>dq;
	static int INF = 100000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		TC = Integer.parseInt(st.nextToken());

		for (int t = 0; t < TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			building = new int[N];
			inNode = new int[N + 1];
			dq = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			
			//건물 짓는 시간 초기화
			for (int i = 0; i < N; i++) {
				building[i] = Integer.parseInt(st.nextToken());
			}

			// 인접 리스트 초기화
			Adjacent = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < N + 1; i++) {
				Adjacent.add(new ArrayList<Integer>());
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				Adjacent.get(start).add(end);
				
				//들어오는 간선 추가
				inNode[end]++;
			}
			
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			
			
			

		}
	}

}
