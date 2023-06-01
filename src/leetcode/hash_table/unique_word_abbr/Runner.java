package leetcode.hash_table.unique_word_abbr;

public class Runner {
    public static void main(String[] args) {
        String[] words = {
                "deer","door","cake","card"
        };
        Boolean[] ans = {false,true,false,true,true};
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(words);
        System.out.println(validWordAbbr.isUnique("dear")== ans[0]);
        System.out.println(validWordAbbr.isUnique("cart")== ans[1]);
        System.out.println(validWordAbbr.isUnique("cane")== ans[2]);
        System.out.println(validWordAbbr.isUnique("make")== ans[3]);
        System.out.println(validWordAbbr.isUnique("cake")== ans[4]);

//        String[] words = {
//                "a","a"
//        };
//        Boolean[] ans = {true};
//        ValidWordAbbr validWordAbbr = new ValidWordAbbr(words);
//        System.out.println(validWordAbbr.isUnique("a")== ans[0]);

        //["ValidWordAbbr","isUnique","isUnique","isUnique","isUnique","isUnique"]
        //[[["deer","door","cake","card"]],["dear"],["cart"],["cane"],["make"],["cake"]]
        //[null,false,true,false,true,true]



    }

    //["ValidWordAbbr","isUnique","isUnique","isUnique","isUnique"]
    //[[["deer","door","cake","card"]],["dear"],["door"],["cart"],["cake"]]
}
