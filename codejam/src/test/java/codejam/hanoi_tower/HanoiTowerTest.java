package codejam.hanoi_tower;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

/**
 * 
 * @author dgamez
 *
 */
public class HanoiTowerTest {

    @Test
    public void testMove() {
    	System.out.println("Testing Hanoi's Towers with 10 disks");
        Stack<HanoiDisk> towerA = new Stack<HanoiDisk>();
        initTower(towerA, 10);
        Stack<HanoiDisk> towerB = new Stack<HanoiDisk>();
        Stack<HanoiDisk> towerC = new Stack<HanoiDisk>();
        HanoiTower hanoiTower = new HanoiTower();
        int moves = hanoiTower.move(towerA, towerC, towerB);
        
        assertEquals(0, towerA.size());
        assertEquals(0, towerB.size());
        assertEquals(10, towerC.size());
                
        System.out.print("Tower A: ");
        outputTower(towerA);
        System.out.print("Tower B: ");
        outputTower(towerB);
        System.out.print("Tower C: ");
        outputTower(towerC);
        System.out.println("solved in " + String.valueOf(moves));
    }
    
    private void outputTower(Stack<HanoiDisk> tower) {
        if (!tower.isEmpty()){
        	System.out.println();
            while(!tower.isEmpty()){
                HanoiDisk hanoiDisk = tower.pop();
                System.out.println(hanoiDisk.toString());
            }
        }else{
            System.out.println("Tower is empty");
        }
    }

    private void initTower(Stack<HanoiDisk> tower, int diskNumber){
        for(int i = diskNumber -1; i >=0; i--){
            HanoiDisk disk = new HanoiDisk(i);
            tower.push(disk);
        }        
    }

}
