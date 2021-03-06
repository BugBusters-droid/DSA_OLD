package Interview1;

import org.testng.annotations.Test;

public class Test7 {


    public boolean match() {
        String s = "abcdef";
        String p = "a?c*f";

        int m = s.length(),n = p.length();
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;

        // * can occupy empty space
        // Therefore traverse column and find *
        for(int i = 1; i <= n; i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }

                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }


    @Test
    public void test(){
        System.out.println(match());
    }
}

