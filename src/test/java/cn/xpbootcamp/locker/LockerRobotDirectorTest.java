package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LockerRobotDirectorTest {
    @Test
    public void should_return_the_report_of_locker_use_when_query_given_1_manager_manage_2_robots_both_manage_1_locker_and_not_manage_locker() {
        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(List.of(new Locker(3)));
        robot1.saveBag(new Bag());
        SmartLockerRobot robot2 = new SmartLockerRobot(List.of(new Locker(5)));
        robot2.saveBag(new Bag());
        LockerRobotManager manager = new LockerRobotManager(List.of(robot1, robot2));
        LockerRobotDirector director = new LockerRobotDirector(List.of(manager));

        StringBuilder report = director.getReport();

        String expectReport = "M 6 8" +
                "\n\tR 2 3" +
                "\n\t\tL 2 3" +
                "\n\tR 4 5" +
                "\n\t\tL 4 5";
        Assert.assertEquals(expectReport, report.toString());
    }
}
