package leetcode.queue_stack.valid_parenthesis;

public class Runner {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(new Solution().isValid(s));
        System.out.println(new Solution().isValid("{}{}{}{()}[{()()()()()}]]]]]]]]]]]]]]]]]]]]]]]]]"));
        System.out.println(new Solution().isValid("{}{}{}{()}[{()()[}]()()}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}]"));

    }
}
