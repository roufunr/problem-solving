package leetcode.two_thousand_23.hash_table.insert_delete_getrandom;

public class Runner {
    public static void main(String[] args) {
        // ["RandomizedSet","remove","remove","insert","getRandom","remove","insert"]
        // [[],[0],[0],[0],[],[0],[0]]
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.remove(0);
        randomizedSet.remove(0);
        randomizedSet.insert(0);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(0);
        randomizedSet.insert(0);
    }
}
