class RandomizedSet {

     private Set<Integer> set = new HashSet<>();
    private List<Integer> list = new ArrayList<>();
    public RandomizedSet() {

    }

    public boolean insert(int val) {
        boolean res = set.add(val);
        if (res )list.add(val);
        return res;
    }

    public boolean remove(int val) {
        list.remove(Integer.valueOf(val));
        return set.remove(val);
    }

    public int getRandom() {
        int val = list.get(ThreadLocalRandom.current().nextInt(list.size()));
        return val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */