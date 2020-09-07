package cn.xpbootcamp.locker;

import java.util.ArrayList;

public class LockerRobotManager {
    final ArrayList<Robot> managedList;

    public LockerRobotManager(ArrayList<Robot> managedList) {
        this.managedList = managedList;
    }

    public Receipt saveBag(Bag bag) {
        return this.managedList.get(0).saveBag(bag);
    }
}
