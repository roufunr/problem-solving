package random;
//https://codeforces.com/contest/1721/problem/B

import java.util.Scanner;

public class DeadlyLaser {
	public static void main(String[] args) {
		int N;
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    for(int i = 0; i < N; i++) {
	        int n,m,sx,sy,d;
	        n = sc.nextInt();
	        m = sc.nextInt();
	        sx = sc.nextInt();
	        sy = sc.nextInt();
	        d = sc.nextInt();
	        //System.out.print(i + " > ");
	        if(validateCondition(n, m, sx, sy, d)) {
	        	
	            System.out.println(n + m - 2);
	        } else {
	        	System.out.println(-1);
	        }
	    }
	}
	
	static boolean validateCondition(int n, int m, int sx, int sy, int d) {
	    int sxplusd = sx + d;
	    int sxminusd = sx - d;
	    int syplusd = sy + d;
	    int syminusd = sy - d;
	    
	    if(sx + sy - 2 <= d) {
	    	return false;
	    }

	    if(sxplusd >= n && syplusd >= m) {
	    	return false;
	    } else if(sxminusd <= 1 && syminusd <= 1) {
	    	return false;
	    } else if(sxplusd >= n && sxminusd <= 1) {
	    	return false;
	    } else if(syplusd >= m && syminusd <= 1) {
	    	return false;
	    } else {
	    	return true;
	    }
	}
}
