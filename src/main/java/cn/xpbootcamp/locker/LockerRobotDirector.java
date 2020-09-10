package cn.xpbootcamp.locker;

import java.util.List;

public class LockerRobotDirector {
    private List<LockerRobotManager> managers;

    public LockerRobotDirector(List<LockerRobotManager> managers) {
        this.managers = managers;
    }

    public StringBuilder getReport() {
        LockerRobotManager manager = this.managers.get(0);
        return manager.getReport();
    }
}
