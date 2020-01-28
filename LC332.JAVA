// Problem Statement
// https://leetcode.com/problems/reconstruct-itinerary/
 
public class Solution {
    public List<String> route = new ArrayList<String>();
    public HashMap<String,List<String>> hmap = new HashMap<String,List<String>>();
    int numAirport;
    int numAirportUsed;
   
    public List<String> findItinerary(String[][] tickets) {
       
        // graph formation
        for(String[] ticket : tickets){
            if(!hmap.containsKey(ticket[0])){
                List<String> list = new ArrayList<String>();
                list.add(ticket[1]);
                hmap.put(ticket[0],list);
            }
            else hmap.get(ticket[0]).add(ticket[1]);
        }
        numAirport = tickets.length;
       
        for(Map.Entry<String,List<String>> entry : hmap.entrySet()){
            Collections.sort(entry.getValue());
        }
       
        route.add("JFK");
        dfs("JFK");
        return route;
    }
   
    public void dfs(String airportCode){
       
        if(!hmap.containsKey(airportCode)) return;
        List<String> temp = hmap.get(airportCode);
       
        for(int i=0; i<temp.size(); i++){
            String next = temp.get(i);
            route.add(next);
            temp.remove(i);
            numAirportUsed++;
           
            dfs(next);
           
            if(numAirportUsed==numAirport) return;
           
            route.remove(route.size()-1);
            temp.add(i,next);
            numAirportUsed--;
        }
    }
   

