package leetcode.daily_challenge.july_25.maximum_matching_of_players_with_trainers_13;

import java.util.Arrays;

public class Solution {
    private int search(int[] trainers, int left, int playerCapability) {
        int right = trainers.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(trainers[mid] >= playerCapability) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left == trainers.length ? -1 : left;
    }
    
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int matchCount = 0;
        int left = 0;
        for(int i = 0; i < players.length; i++) {
            int playerCapability = players[i];
            int trainerIdx = search(trainers, left, playerCapability);
            if(trainerIdx == -1) {
                break;
            }
            matchCount++;
            left = trainerIdx + 1;
        }
        return matchCount;
    }
}