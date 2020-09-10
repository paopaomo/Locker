package cn.xpbootcamp.locker;

import java.util.List;

public class LockerRobotDirector {
    private List<LockerRobotManager> managers;

    public LockerRobotDirector(List<LockerRobotManager> managers) {
        this.managers = managers;
    }

    public StringBuilder getReport() {
        StringBuilder info = new StringBuilder(managers.get(0).getReport());
        for(int i = 1; i < managers.size(); i++) {
            info.append("\n").append(managers.get(i).getReport());
        }
        return info;
    }
}
