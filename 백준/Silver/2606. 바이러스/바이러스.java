import java.util.*;

public class Main{
	static int cnt = 0;
	
	static void dfs(int [][]a, boolean[] check, int v) {
		if(check[v] == true) return;
		
		check[v] = true;
		cnt++;
		
		for(int i = 0; i < a[v].length; i++) {
			if(a[v][i] == 1 && !check[i]) {
				dfs(a, check, i);
			}
		}
	}
	public static void main(String[] args){
		int n, m;
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m = scan.nextInt();
		
		int[][] graph = new int[n+1][n+1];
		boolean[] check = new boolean[n+1];
		
		for(int i = 0; i < m; i++) {
			int v = scan.nextInt();
			int w = scan.nextInt();
			
			graph[v][w] = 1;
			graph[w][v] = 1;
		}
		
		dfs(graph, check, 1);
		
		System.out.println(cnt - 1);
	}
}
