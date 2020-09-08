package cn.xpbootcamp.locker;

import org.assertj.core.util.Lists;

import java.util.ArrayList;

public class LockerRobotManager {
    final private ArrayList<Robot> robots = Lists.newArrayList();

    public void manageRobot(ArrayList<Robot> robots) {
        this.robots.addAll(robots);
    }

    public Receipt saveBag(Bag bag) {
        for(Robot robot: robots) {
            if(!robot.isAllLockerFull()) {
                return robot.saveBag(bag);
            }
        }
        throw  new LockerIsFullException();
    }
}
