package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public class SmartLockerRobot {
    private List<Locker> lockers;

    public SmartLockerRobot(ArrayList<Locker> lockers) {
        this.lockers = lockers;
    }

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
