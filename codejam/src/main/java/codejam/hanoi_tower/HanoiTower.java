/**
 * 
 */
package codejam.hanoi_tower;

import java.util.Stack;

/**
 * 
 * @author dgamez
 *
 */
public class HanoiTower {

	/**
	 * This method moves the Disks from towerA to towerB using towerC as temporal tower
	 * @param towerA Tower used as from 
	 * @param towerC Tower used as to
	 * @param towerB Tower used as temporal
	 * @return the number of moves
	 */
    public int move(Stack<HanoiDisk> towerA, Stack<HanoiDisk> towerC, Stack<HanoiDisk> towerB){
        return move(towerA, towerC, towerB, towerA.size(), 0);
    }
    
    protected int move(Stack<HanoiDisk> towerA, Stack<HanoiDisk> towerC, Stack<HanoiDisk> towerB, int diskNumber, int moves){
        if (diskNumber >= 1){
            moves = move(towerA, towerB, towerC, diskNumber -1, moves);
            moves += moveDisk(towerA, towerC);
            moves = move(towerB, towerC, towerA, diskNumber -1, moves);
        }
        return moves;
    }
    
    protected int moveDisk(Stack<HanoiDisk> fromTower, Stack<HanoiDisk> toTower){
        int result = 0;
        if (fromTower.size() > 0){
            HanoiDisk disk = fromTower.pop();
            toTower.push(disk);
            result = 1;
        }
        return result;
    }
    
}