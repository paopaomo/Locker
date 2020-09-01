package cn.xpbootcamp.locker;

import com.sun.tools.javac.util.List;

public class PrimaryLockerRobot {
    private List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public RobotReceipt saveBag(Bag bag) {
        for(int i = 0; i < lockers.size(); i++) {
            Locker locker = lockers.get(i);
            if(locker.getCurrentStorage() < locker.capacity) {
                Receipt receipt = locker.saveBag(bag);
                return new RobotReceipt(i, receipt);
            }
        }
        throw new LockerIsFullException();
    }

    public Bag takeBag(RobotReceipt robotReceipt) {
        int lockerIndex = robotReceipt.getLockerIndex();
        Receipt receipt = robotReceipt.getReceipt();
        return lockers.get(lockerIndex).takeBag(receipt);
    }
}
