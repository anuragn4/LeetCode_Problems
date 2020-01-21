//Problem Statement
//https://leetcode.com/problems/couples-holding-hands/ 

class Solution {
    Map<Integer,Integer>map;
    int n;
    public int minSwapsCouples(int[] row) {
        n=row.length;
        map = new HashMap<Integer, Integer>();
        int cnt = 0;
        for(int i=0; i<n; i++) map.put(row[i],i);
        
        for(int i=1; i<n; i=i+2){
            int prev = row[i-1];
            if(prev%2==0){
                if(row[i]==prev+1) continue;
                else{
                    int temp = map.get(prev+1);
                    map.put(row[i],temp);
                    row[temp] = row[i];
                    cnt++;
                }
            }
            else{
                if (row[i]==prev-1) continue;
                else{
                    int temp = map.get(prev-1);
                    map.put(row[i],temp);
                    row[temp]= row[i];
                    cnt++;
                }
            }
        }
        
        return cnt;        
    }
}
