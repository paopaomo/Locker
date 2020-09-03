package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public class SmartLockerRobot {
    private List<Locker> lockers;

    public SmartLockerRobot(ArrayList<Locker> lockers) {
        this.lockers = lockers;
    }

    public Receipt saveBag(Bag bag) {
        return this.lockers.get(0).saveBag(bag);
    }
}
