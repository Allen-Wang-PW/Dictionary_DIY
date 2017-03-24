package Data;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringDistance {
	int dp[][];// matrix

	public int getStringSimilar(String s1, String s2) {
		int n, m;// respective length
		int i, j;// cursor
		n = s1.length();
		m = s2.length();
		 if (n == 0 || m == 0) {
		 return Math.abs(m - n);
		 }
		
		dp = new int[n][m];
		for (i = 0; i < n; i++)
			dp[i][0] = 1 + i;
		for (i = 0; i < m; i++)
			dp[0][i] = 1 + i;
		for (i = 0; i < n; i++) 
			for (j = 0; j < m; j++) 
				if (s1.charAt(i) == s2.charAt(j))
					dp[i][j] = getDP(i - 1, j - 1);
				else
					//注意是min(a,b,c)三个形参
					dp[i][j] = min(getDP(i - 1, j), getDP(i, j - 1), getDP(i-1, j - 1)) + 1;
		return dp[n - 1][m - 1];
	}

	private int min(int a, int b, int c) {
		return Math.min(Math.min(a, b),c);
	}

	int getDP(int i, int j) {
		if (i <0 && j <0)
			return 0;
		if(i<0)
			return j+1;
		if(j<0)
			return i+1;
		else 
			return dp[i][j];
	}

	public static int getStringDistance(String s1, String s2) {
		StringDistance obj = new StringDistance();
		return obj.getStringSimilar(s1, s2);
	}
	@Test
	public void testGetStringSimilar(){
		assertEquals(3,getStringSimilar("kitten", "sitting"));
	}
	
}
