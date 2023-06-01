package leetcode.heap.find_median_from_data_stream;

public class Runner {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        for(int i = 0; i < 10; i++) {
            int x = (int)(Math.random() * 100 ) % 100;
            medianFinder.addNum(x);
            System.out.println("Added: " + (x));
            System.out.println(medianFinder.findMedian());
        }
    }
}

//["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
