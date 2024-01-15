class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> winner = new HashMap<>(); 
        HashMap<Integer, Integer> loser = new HashMap<>(); 

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (int[] list : matches) {
            winner.put(list[0], winner.getOrDefault(list[0], 0) + 1);
            loser.put(list[1], loser.getOrDefault(list[1], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> map : winner.entrySet()) {
            if (loser.get(map.getKey()) == null) {
                first.add(map.getKey());
            }
        }

        for (Map.Entry<Integer, Integer> map : loser.entrySet()) {
            if (map.getValue() == 1) {
                second.add(map.getKey());
            }
        }

        Collections.sort(first);
        Collections.sort(second);
        res.add(first);
        res.add(second);

        return res;
    }
}