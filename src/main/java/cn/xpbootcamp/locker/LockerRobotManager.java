package cn.xpbootcamp.locker;

import java.util.ArrayList;

public class LockerRobotManager {
    final ArrayList<Robot> managedList;

    public LockerRobotManager(ArrayList<Robot> managedList) {
        this.managedList = managedList;
    }

    public Receipt saveBag(Bag bag) {
        for(Robot robot: managedList) {
            if(!robot.isAllLockerFull()) {
                return robot.saveBag(bag);
            }
        }
        throw  new LockerIsFullException();
    }
}
