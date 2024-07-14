package leetcode.daily_challenge.number_of_atoms;

import java.util.*;

class Pair {
    public int count;
    public int idx;

    public Pair(int count, int idx) {
        this.count = count;
        this.idx = idx;
    }
}

public class Solution {
    private List<String> parse(String formula) {
        StringBuilder number = new StringBuilder();
        StringBuilder element = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = formula.length() - 1; i >= 0; i--) {
            char c = formula.charAt(i);
            if (c >= '0' && c <= '9') {
                number.append(c);
            } else if (c == ')') {
                if (number.length() == 0) {
                    number.append('1');
                }

                list.add(number.reverse().toString());
                list.add(")");
                number.setLength(0);
            } else if (c >= 'a' && c <= 'z') {
                element.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                element.append(c);
                if (number.length() == 0) {
                    number.append('1');
                }
                list.add(number.reverse().toString());
                list.add(element.reverse().toString());
                number.setLength(0);
                element.setLength(0);
            } else {
                list.add(c + "");
            }
        }
        Collections.reverse(list);
        return list;
    }

    public String countOfAtoms(String formula) {
        List<String> list = parse(formula);
        List<String> elementList = new ArrayList<>();
        List<Integer> mul = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
                int number = Integer.parseInt(list.get(i + 1));
                elementList.add(str);
                mul.add(number);
            }
            if (str.equals("(")) {
                elementList.add(str);
                mul.add(0);
            } else if (str.equals(")")) {
                int number = Integer.parseInt(list.get(i + 1));
                elementList.add(str);
                mul.add(number);
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).equals("(")) {
                stack.push(i + 1);
            } else if (elementList.get(i).equals(")")) {
                int number = mul.get(i);
                for (int j = stack.pop(); j < i; j++) {
                    if (elementList.get(j).charAt(0) >= 'A' && elementList.get(j).charAt(0) <= 'Z') {
                        mul.set(j, mul.get(j) * number);
                    }
                }
            }
        }
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).equals("(") || elementList.get(i).equals(")")) {
                continue;
            } else {
                map.put(elementList.get(i), map.getOrDefault(elementList.get(i), 0) + mul.get(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            if(entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}