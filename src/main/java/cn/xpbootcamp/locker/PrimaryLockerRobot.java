package cn.xpbootcamp.locker;

import com.sun.tools.javac.util.List;

public class PrimaryLockerRobot {
    private List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public RobotReceipt saveBag(Bag bag) {
        for(Locker locker: lockers) {
            if(locker.getCurrentStorage() < locker.capacity) {
                locker.saveBag(bag);
                return new RobotReceipt();
            }
        }
        throw new LockerIsFullException();
    }
}
