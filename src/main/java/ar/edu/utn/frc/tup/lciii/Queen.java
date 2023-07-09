package ar.edu.utn.frc.tup.lciii;

import java.awt.*;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class Queen {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */
    private boolean isValidPosition(int[] position, int topLimit){
        return position[0] <= topLimit && position[0] >= 1 && position[1] <= topLimit && position[1] >= 1;
    }

    private boolean isThereAnObstacule(int[] position,List<List<Integer>> obstacles){
        for (List<Integer> o:obstacles) {
            Integer obstacleRow = o.get(0);
            Integer obstacleCol = o.get(1);
         if(obstacleCol == position[1] && obstacleRow == position[0]){
             return true;
         }
        }
        return false;
    }

    public Integer queensAttack(Integer n, Integer k, Integer r_q, Integer c_q, List<List<Integer>> obstacles) {
        // Write your code here
        Integer result = 0;
        int foundedObstacles = 0;
        int[][] queensPathsIncrements = {{1, 0}, {1, -1}, {0, -1},  {-1, -1}, {-1, 0} , {-1, 1}, {0, 1}, {1, 1}};

        for (int[] inc:queensPathsIncrements) {
            boolean thereIsAnObstacle = false;
            int[] currentPosition = {r_q+inc[1], c_q+inc[0]};

            while(isValidPosition(currentPosition, n) && !thereIsAnObstacle){
                    if (obstacles == null || foundedObstacles == k) {
                        result++;
                    }
                    else{
                        if(!isThereAnObstacule(currentPosition, obstacles)) {
                            result++;
                        }
                        else {
                            thereIsAnObstacle = true;
                            foundedObstacles++;
                        }
                    }
                    currentPosition[0] = currentPosition[0] + inc[1];
                    currentPosition[1] = currentPosition[1] + inc[0];
                }
            }
        return result;
    }
}
