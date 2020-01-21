// Problem Statement
// https://leetcode.com/problems/course-schedule-ii/ 

public class Solution {
    
    private ArrayDeque<Integer> sort = new ArrayDeque<Integer>();
    private boolean cycleExist;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList[] graph = new ArrayList[numCourses];
        boolean[] marked = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++) graph[i] = new ArrayList();
        
        for(int i=0; i<prerequisites.length; i++) graph[prerequisites[i][1]].add(prerequisites[i][0]);
        
        for(int i=0; i<numCourses; i++) if(!marked[i]) dfs(graph,marked,onStack,i);     
        
        if(cycleExist) return new int[0];
        
        int[] result = new int[sort.size()];
        
        for(int i=0; i<result.length; i++) result[i] = (int)sort.pop();
        
        return result;
    }
    
    public void dfs(ArrayList[] graph, boolean[] marked, boolean[] onStack, int course){
        marked[course] = true;
        if(onStack[course]) cycleExist=true;
        else{
            onStack[course] = true;
            for(int i=0; i<graph[course].size(); i++){
                int temp = (int)graph[course].get(i);
                if(onStack[temp]) cycleExist=true;
                else if(!marked[temp]) dfs(graph,marked,onStack,temp);
            }
            onStack[course]=false;
            sort.push(course);
        }
    }
} 

