import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }
        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int curr_dir = 0;
        int ans = 0;
        int[] curr_position = {0, 0};

        for (int command : commands) {
            if (command == -1) {
                
                curr_dir = (curr_dir + 1) % 4;
            } else if (command == -2) {
                
                curr_dir = (curr_dir + 3) % 4;
            } else {
               
                int[] direction = directions[curr_dir];
                for (int step = 0; step < command; step++) {
                    int nextX = curr_position[0] + direction[0];
                    int nextY = curr_position[1] + direction[1];
                    String nextPosition = nextX + "," + nextY;

                   
                    if (set.contains(nextPosition)) {
                        break;
                    } else {
                        curr_position[0] = nextX;
                        curr_position[1] = nextY;
                        
                        ans = Math.max(ans, curr_position[0] * curr_position[0] + curr_position[1] * curr_position[1]);
                    }
                }
            }
        }
        return ans;
    }
}
