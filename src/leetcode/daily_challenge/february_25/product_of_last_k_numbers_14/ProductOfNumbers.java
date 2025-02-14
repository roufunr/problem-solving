package leetcode.daily_challenge.february_25.product_of_last_k_numbers_14;
import java.util.*;
public class ProductOfNumbers {
    private ArrayList<Integer> prefixProduct = new ArrayList<>();
    private int size = 0;

    public ProductOfNumbers() {
        
        this.prefixProduct.add(1);
        this.size = 0;
    }

    public void add(int num) {
        if (num == 0) {
            this.prefixProduct = new ArrayList<Integer>();
            this.prefixProduct.add(1);
            this.size = 0;
        } else {
            this.prefixProduct.add(this.prefixProduct.get(size) * num);
            this.size++;
        }
    }

    public int getProduct(int k) {
        if (k > this.size) return 0;
        return (
            this.prefixProduct.get(this.size) /
            this.prefixProduct.get(this.size - k)
        );
    }
}