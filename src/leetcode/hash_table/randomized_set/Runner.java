package leetcode.hash_table.randomized_set;

public class Runner {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(10);
        randomizedSet.insert(20);
        randomizedSet.insert(30);
        randomizedSet.insert(10);
        randomizedSet.insert(30);
        randomizedSet.insert(50);


        System.out.println(randomizedSet.getRandom());
    }
}
