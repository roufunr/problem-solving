package leetcode.queue_stack.walls_and_gates;

import java.util.*;

enum CellType {
    WALL(-1), GATE(0);
    public final Integer label;
    CellType(int label) {
        this.label = label;
    }
}
class Pair<T, S>{
    public T i;
    public S j;
    Pair(T i, S j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        List<Pair<Integer, Integer>> gates = new ArrayList<>();
        int row = rooms.length;
        int column = rooms[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(rooms[i][j] == CellType.GATE.label) {
                    gates.add(new Pair<>(i, j));
                }
            }
        }

        for(int i = 0; i < gates.size(); i++) {
            runBFS(gates.get(i), rooms);
        }
    }

    public String makeKey(Pair<Integer, Integer> node) {
        return node.i+ "_" + node.j;
    }

    public Pair<Integer, Integer> getPair(String key) {
        int i = Integer.parseInt(key.split("_")[0]);
        int j = Integer.parseInt(key.split("_")[1]);
        return new Pair<>(1, j);
    }

    public void runBFS(Pair<Integer, Integer> gate, int[][] rooms) {
        Map<String, Integer> visited = new HashMap();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(gate);
        visited.put(makeKey(gate), 0);

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.remove();
            rooms[node.i][node.j] = visited.get(makeKey(node));
            //get adjacent
            //upper
            if(node.i - 1 >= 0) {
                Pair<Integer, Integer> upperAdj = new Pair<>(node.i - 1, node.j);
                if(!visited.containsKey(makeKey(upperAdj))
                        && !(rooms[upperAdj.i][upperAdj.j] == CellType.GATE.label || rooms[upperAdj.i][upperAdj.j] == CellType.WALL.label)
                ) {
                    int newDist = visited.get(makeKey(node)) + 1;
                    int oldDist = rooms[upperAdj.i][upperAdj.j];
                    int dist = newDist < oldDist ? newDist : oldDist;
                    visited.put(makeKey(upperAdj), dist);
                    queue.add(upperAdj);
                }
            }

            //lower
            if(node.i + 1 < rooms.length) {
                Pair<Integer, Integer> lowerAdj = new Pair<>(node.i + 1, node.j);
                if(!visited.containsKey(makeKey(lowerAdj))
                        && !(rooms[lowerAdj.i][lowerAdj.j] == CellType.GATE.label || rooms[lowerAdj.i][lowerAdj.j] == CellType.WALL.label)
                ) {
                    int newDist = visited.get(makeKey(node)) + 1;
                    int oldDist = rooms[lowerAdj.i][lowerAdj.j];
                    int dist = newDist < oldDist ? newDist : oldDist;
                    visited.put(makeKey(lowerAdj), dist);
                    queue.add(lowerAdj);
                }
            }
            //left
            if(node.j - 1 >= 0) {
                Pair<Integer, Integer> leftAdj = new Pair<>(node.i, node.j - 1);
                if(!visited.containsKey(makeKey(leftAdj))
                        && !(rooms[leftAdj.i][leftAdj.j] == CellType.GATE.label || rooms[leftAdj.i][leftAdj.j] == CellType.WALL.label)
                ) {
                    int newDist = visited.get(makeKey(node)) + 1;
                    int oldDist = rooms[leftAdj.i][leftAdj.j];
                    int dist = newDist < oldDist ? newDist : oldDist;
                    visited.put(makeKey(leftAdj), dist);
                    queue.add(leftAdj);
                }
            }
            //right
            if(node.j + 1 < rooms[0].length) {
                Pair<Integer, Integer> rightAdj = new Pair<>(node.i, node.j + 1);
                if(!visited.containsKey(makeKey(rightAdj))
                        && !(rooms[rightAdj.i][rightAdj.j] == CellType.GATE.label || rooms[rightAdj.i][rightAdj.j] == CellType.WALL.label)
                ) {
                    int newDist = visited.get(makeKey(node)) + 1;
                    int oldDist = rooms[rightAdj.i][rightAdj.j];
                    int dist = newDist < oldDist ? newDist : oldDist;
                    visited.put(makeKey(rightAdj), dist);
                    queue.add(rightAdj);
                }
            }
        }
    }
}
