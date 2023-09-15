class Solution {
     public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,ArrayList<String>> h = new HashMap<>();
        for(int i=0; i<tickets.size(); i++){
          String s = tickets.get(i).get(0);
          String f = tickets.get(i).get(1);
          if(h.containsKey(s)){
            h.get(s).add(f);
          }
          else{
            ArrayList<String>temp = new ArrayList<>();
            temp.add(f);
            h.put(s,temp);
          }
        }
        for(Map.Entry<String,ArrayList<String>>e:h.entrySet())
        {
          Collections.sort(e.getValue());
        }
        ArrayList<String>list = new ArrayList<>();
        // while(!h.get("JFK").isEmpty()){
          dfs("JFK", h, list);
        // }
        Collections.reverse(list);
        return list;
    }
    public void dfs(String s, HashMap<String,ArrayList<String>> h, ArrayList<String>list)
    {
      while(h.containsKey(s) && !h.get(s).isEmpty()) {
            ArrayList<String> destinations = h.get(s);
            String nextAirport = destinations.remove(0); // Remove the first destination
            dfs(nextAirport, h, list); // Recursively explore the next airport
        } 
        list.add(s);
    }
}