/**
 * @(#)UVa10000.java
 * Longest path
 *
 *
 * @author Bogdan Balas
 * @version 1.00 2013/4/26
 */


import java.util.*;
import java.io.*;

class UVa10000 {

	static int[][] map = new int[102][102];
	static int[][] dp = new int[102][102];

    public static void main(String args[]) throws IOException {
    	//Scanner in = new Scanner(new File("UVa10000.txt"));
		Scanner in = new Scanner(System.in);
    	int run = 1;
    	while (true) {
    		int n = in.nextInt();
    		if (n == 0) {
    			break;
    		}
    		int s = in.nextInt();
    		for (int i = 0; i <= n; i++) {
    			for (int j = 0; j <= n; j++) {
    				map[i][j] = 0;
    				dp[i][j] = -1;
    			}
    			dp[i][i] = 0;
    		}
    		int a = in.nextInt();
    		int b = in.nextInt();
    		while(a != 0 && b != 0) {
    			map[a][b] = 1;
    			a = in.nextInt();
    			b = in.nextInt();
    		}
    		int max = -1;
    		int longest = 0;
    		for (int i = 1; i <= n; i++) {
    			if (dplength(s, i, n) > max) {
    				max = dplength(s, i, n);
    				longest = i;
    			}
    		}

    		System.out.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n\n", run, s, max, longest);
    		run++;
    	}
    	System.exit(0);
    }

    public static int dplength(int s, int t, int n) {
    	if (dp[s][t] != -1) {
    		return dp[s][t];
    	} else {
    		int maximum = -1;
    		for (int i = 1; i <= n; i++) {
    			if (map[s][i] != 0) {
    				maximum = Math.max(maximum, 1 + dplength(i, t, n));
    			}
    		}
    		dp[s][t] = maximum;
    		return dp[s][t];
    	}
    }

}
