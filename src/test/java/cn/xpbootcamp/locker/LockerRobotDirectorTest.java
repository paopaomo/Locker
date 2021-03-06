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

    @Test
    public void should_return_the_report_of_locker_use_when_query_given_1_manager_manage_2_robots_both_manage_2_lockers_and_not_manage_locker() {
        Locker locker1 = new Locker(1);
        locker1.saveBag(new Bag());
        Locker locker2 = new Locker(2);
        locker2.saveBag(new Bag());
        PrimaryLockerRobot robot1 = new PrimaryLockerRobot(List.of(locker1, locker2));
        Locker locker3 = new Locker(3);
        locker3.saveBag(new Bag());
        Locker locker4 = new Locker(2);
        locker4.saveBag(new Bag());
        SmartLockerRobot robot2 = new SmartLockerRobot(List.of(locker3, locker4));
        LockerRobotManager manager = new LockerRobotManager(List.of(robot1, robot2));
        LockerRobotDirector director = new LockerRobotDirector(List.of(manager));

        StringBuilder report = director.getReport();

        String expectReport = "M 4 8" +
                "\n\tR 1 3" +
                "\n\t\tL 0 1" +
                "\n\t\tL 1 2" +
                "\n\tR 3 5" +
                "\n\t\tL 2 3" +
                "\n\t\tL 1 2";
        Assert.assertEquals(expectReport, report.toString());
    }

    @Test
    public void should_return_the_report_of_locker_use_when_query_given_1_manager_manage_2_lockers_and_not_manage_robot() {
        Locker locker1 = new Locker(3);
        locker1.saveBag(new Bag());
        Locker locker2 = new Locker(5);
        locker2.saveBag(new Bag());
        LockerRobotManager manager = new LockerRobotManager(List.of(locker1, locker2));
        LockerRobotDirector director = new LockerRobotDirector(List.of(manager));

        StringBuilder report = director.getReport();

        String expectReport = "M 6 8" +
                "\n\tL 2 3" +
                "\n\tL 4 5";
        Assert.assertEquals(expectReport, report.toString());
    }

    @Test
    public void should_return_the_report_of_locker_use_when_query_given_1_manager_manage_1_locker_and_1_robot_has_1_locker() {
        Locker locker = new Locker(3);
        locker.saveBag(new Bag());
        PrimaryLockerRobot robot = new PrimaryLockerRobot(List.of(new Locker(5)));
        robot.saveBag(new Bag());
        LockerRobotManager manager = new LockerRobotManager(List.of(locker, robot));
        LockerRobotDirector director = new LockerRobotDirector(List.of(manager));

        StringBuilder report = director.getReport();

        String expectReport = "M 6 8" +
                "\n\tL 2 3" +
                "\n\tR 4 5" +
                "\n\t\tL 4 5";
        Assert.assertEquals(expectReport, report.toString());
    }

    @Test
    public void should_return_the_report_of_locker_use_when_query_given_1_manager_manage_1_locker_and_1_robot_has_2_lockers() {
        Locker locker = new Locker(3);
        locker.saveBag(new Bag());
        Locker locker1 = new Locker(2);
        locker1.saveBag(new Bag());
        Locker locker2 = new Locker(3);
        locker2.saveBag(new Bag());
        PrimaryLockerRobot robot = new PrimaryLockerRobot(List.of(locker1, locker2));
        LockerRobotManager manager = new LockerRobotManager(List.of(locker, robot));
        LockerRobotDirector director = new LockerRobotDirector(List.of(manager));

        StringBuilder report = director.getReport();

        String expectReport = "M 5 8" +
                "\n\tL 2 3" +
                "\n\tR 3 5" +
                "\n\t\tL 1 2" +
                "\n\t\tL 2 3";
        Assert.assertEquals(expectReport, report.toString());
    }

    @Test
    public void should_return_the_report_of_locker_use_when_query_given_2_manager_both_manage_1_locker() {
        LockerRobotManager manager1 = new LockerRobotManager(List.of(new Locker(3)));
        manager1.saveBag(new Bag());
        LockerRobotManager manager2 = new LockerRobotManager(List.of(new Locker(4)));
        manager2.saveBag(new Bag());
        LockerRobotDirector director = new LockerRobotDirector(List.of(manager1, manager2));

        StringBuilder report = director.getReport();

        String expectReport = "M 2 3" +
                "\n\tL 2 3" +
                "\nM 3 4" +
                "\n\tL 3 4";
        Assert.assertEquals(expectReport, report.toString());
    }

    @Test
    public void should_return_the_report_of_locker_use_when_query_given_1_manager_is_managed_and_1_manager_is_not_managed() {
        LockerRobotManager manager1 = new LockerRobotManager(List.of(new Locker(3)));
        manager1.saveBag(new Bag());
        LockerRobotManager manager2 = new LockerRobotManager(List.of(new Locker(4)));
        manager2.saveBag(new Bag());
        LockerRobotDirector director = new LockerRobotDirector(List.of(manager1));

        StringBuilder report = director.getReport();

        String expectReport = "M 2 3" +
                "\n\tL 2 3";
        Assert.assertEquals(expectReport, report.toString());
    }
}
