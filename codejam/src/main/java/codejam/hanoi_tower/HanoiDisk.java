package codejam.hanoi_tower;

/**
 * This class represents a disk in Tower of Hanoi problem
 * @author dgamez
 *
 */
public class HanoiDisk {

    private int size;
    public HanoiDisk(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    
    @Override
    public String toString(){
        return String.valueOf(size);
    }
}
