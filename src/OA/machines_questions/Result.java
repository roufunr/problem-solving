package OA.machines_questions;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public int getMinimumOperations(List<Integer> items) {
        int opCount = 0;
        List<Integer> copiedItems = new ArrayList<>();
        for(int i = 0; i < items.size(); i++) {
            copiedItems.add(items.get(i));
        }
        for(int i = 1; i < items.size(); i+=1) {
            System.out.println(items.get(i- 1));
            System.out.println(items.get(i));
            while(items.get(i) % 2 == 0) {
                items.set(i, items.get(i) / 2);
                opCount++;
            }

            while(items.get(i - 1) % 2 != 0) {
                items.set(i - 1, items.get(i - 1) / 2);
                opCount++;
            }
        }
        int opCount2 = 0;
        for(int i = 1; i < items.size(); i+=2) {
            System.out.println(copiedItems.get(i - 1));
            System.out.println(copiedItems.get(i));
            while(copiedItems.get(i) % 2 != 0) {
                copiedItems.set(i, copiedItems.get(i) / 2);
                opCount++;
            }

            while(copiedItems.get(i - 1) % 2 == 0) {
                copiedItems.set(i - 1, copiedItems.get(i - 1) / 2);
                opCount++;
            }
        }
        
        return Math.min(opCount, opCount2);
    }
}
