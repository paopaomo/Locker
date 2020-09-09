package cn.xpbootcamp.locker;

import java.util.ArrayList;

public class SmartLockerRobot extends Robot {
    public SmartLockerRobot(ArrayList<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Receipt saveBag(Bag bag) {
        Locker locker = getMaxAvailableLocker();
        return locker.saveBag(bag);
    }

    private Locker getMaxAvailableLocker() {
        Locker maxAvailableLocker = lockers.get(0);
        for(int i = 1; i < lockers.size(); i++) {
            maxAvailableLocker = getMoreAvailableLocker(maxAvailableLocker, lockers.get(i));
        }
        return maxAvailableLocker;
    }

    private Locker getMoreAvailableLocker(Locker locker1, Locker locker2) {
        if(locker1.getAvailableCapacity() < locker2.getAvailableCapacity()) {
            return locker2;
        }
        return locker1;
    }
}
