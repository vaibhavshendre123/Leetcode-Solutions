class Solution {
    public int helper(int index,int amount, int[] coins,int[][] dp){

        if(amount==0) return 1;

        if(index == coins.length) return 0;

        if(dp[index][amount] != -1) return dp[index][amount];

        int take = 0;

        if(coins[index]<=amount){
            take = helper(index,amount-coins[index],coins,dp);
        }

        int skip = helper(index+1,amount,coins,dp);

        return dp[index][amount]= take+skip;
    }
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(0,amount, coins,dp);
    }
}