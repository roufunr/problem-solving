package leetcode.daily_challenge.september_24.my_calender_26;

import java.util.*;

public class MyCalendar {
    List<int[]> calendar;

    MyCalendar() {
        calendar = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv : calendar) {
            if (iv[0] < end && start < iv[1]) {
                return false;
            }
        }
        calendar.add(new int[] { start, end });
        return true;
    }
}