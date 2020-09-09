package cn.xpbootcamp.locker;

import java.util.List;

public class PrimaryLockerRobot extends Robot {
    public PrimaryLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Receipt saveBag(Bag bag) {
        for (Locker locker : lockers) {
            if (locker.hasAvailableCapacity()) {
                return locker.saveBag(bag);
            }
        }
        throw new LockerIsFullException();
    }
}
