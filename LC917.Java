https://leetcode.com/problems/find-the-town-judge/ 

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] getting_trust = new int[N+1];
        int[] giving_trust = new int[N+1];
        
        for(int i=0; i<trust.length; i++){
            giving_trust[trust[i][0]]++;
            getting_trust[trust[i][1]]++;                
        }
        
        int town_judge = -1;
        int count = 0;
        
        for(int i=1; i<=N; i++){
            if(getting_trust[i]==N-1){
                town_judge=i;
                count++;
            }
        }        
        if(count>1 || town_judge<0 || giving_trust[town_judge]>0) return -1;
        return town_judge;
    }
}
