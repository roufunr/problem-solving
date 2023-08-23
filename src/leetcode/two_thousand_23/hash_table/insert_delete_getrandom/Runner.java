package leetcode.two_thousand_23.hash_table.insert_delete_getrandom;

public class Runner {
    public static void main(String[] args) {
        // ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
        // [[],[-1],[-2],[-2],[],[-1],[-2],[]]
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(-1);
        randomizedSet.remove(-2);
        randomizedSet.insert(-2);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(-1);
        randomizedSet.remove(-2);
        System.out.println(randomizedSet.getRandom());
    }
}
