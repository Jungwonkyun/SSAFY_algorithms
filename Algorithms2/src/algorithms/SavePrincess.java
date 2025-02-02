package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
input N,M,T, Array

(0,0) -> (N-1,M-1)까지 가는 길 

1. 벽을 뚫고 가지 않는 최단 경로 
2. 그람을 먹고 벽을 뚫고 가는 경로

2-1 그람을 먹은 다음엔 그람까지의 최단 경로 + 맨하탄 거리로 계산 

BFS를 이용 

*/

class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SavePrincess {

	static int N,M,T;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		//input 처리 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int add = Integer.parseInt(st.nextToken());
				if(add==0)map[i][j] = add;
				else map[i][j] = -add;
			}
		}

		BFS();
		
		//벽을 뚫지 않으면 가지 못하는 경우는 무조건 그람을 먹고 가야함
		if(map[N-1][M-1]!=0)result = Math.min(result, map[N-1][M-1]);

		//어떻게 해도 못 가거나 시간이 초과되면 Fail
		if(result == 0 || result > T){
			System.out.println("Fail");
		}
		
		else System.out.println(result);
		
	}
	
	public static void BFS() {
		
		Deque<Node> q =  new LinkedList<>();
		Node Start = new Node(0,0);
		q.add(Start);
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node Now = q.poll();
			int x = Now.x;
			int y = Now.y;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				//범위 벗어나거나 이미 방문한 경우 리턴  
				if(nx<0||nx>=N||ny<0||ny>=M||map[nx][ny]==-1||visited[nx][ny])continue;
				
				//마검을 먹는 경우
				if(map[nx][ny] == -2) {
					int sword = map[x][y]+1+ Math.abs((N-1)-nx)+ Math.abs((M-1)-ny);
					result = Math.min(result, sword);
				}
				
				map[nx][ny] = map[x][y]+1;
				visited[nx][ny] = true;
				Node next = new Node(nx,ny);
				q.offer(next);
			}
		}
		
	}

}
