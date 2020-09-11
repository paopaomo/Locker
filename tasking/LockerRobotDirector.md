### LockerRobotDirector

1.Given LockerRobotDirector 管理一个 lockerRobotManager, lockerRobotManager 管理两个robot, 两个robot的可用容量和总容量分别为: 2-3, 4-5, 两个robot均管理一个locker, 没有管理locker

When LockerRobotDirector 查看报表

Then LockerRobotDirector 看到报表内容为
    
    M 6 8
        R 2 3
            L 2 3
        R 4 5
            L 4 5


2.Given LockerRobotDirector 管理一个 lockerRobotManager, lockerRobotManager 管理两个robot, 两个robot的可用容量和总容量分别为: 1-3, 2-5, 两个robot分别管理两个locker,可用容量和总容量分别为[0-1,1-2], [1-3,1-2], 没有管理locker

When LockerRobotDirector 查看报表

Then LockerRobotDirector 看到报表内容为

    M 4 8
        R 1 3
            L 0 1
            L 1 2
        R 3 5
            L 2 3
            L 1 2

3.Given LockerRobotDirector 管理一个 lockerRobotManager, lockerRobotManager 管理两个locker, 两个locker的可用容量和总容量分别为: 2-3, 4-5, 没有管理robot

When LockerRobotDirector 查看报表

Then LockerRobotDirector 看到报表内容为

    M 6 8
        L 2 3
        L 4 5

4.Given LockerRobotDirector 管理一个 lockerRobotManager, lockerRobotManager 管理一个locker, 该locker的可用容量和总容量为2-3, 管理一个robot, 其可用容量和总容量为4-5, 且只管理一个locker

When LockerRobotDirector 查看报表

Then LockerRobotDirector 看到报表内容为

    M 6 8
        L 2 3
        R 4 5
            L 4 5

5.Given LockerRobotDirector 管理一个 lockerRobotManager, lockerRobotManager 管理一个locker, 该locker的可用容量和总容量为2-3, 管理一个robot, 其可用容量和总容量为3-5, robot管理两个locker,可用容量和总容量为[1-2,2-3]

When LockerRobotDirector 查看报表

Then LockerRobotDirector 看到报表内容为

    M 5 8
        L 2 3
        R 3 5
            L 1 2
            L 2 3

6.Given LockerRobotDirector 管理两个 lockerRobotManager, lockerRobotManager1 管理1个locker,其可用容量和总容量为2-3,  lockerRobotManager2 管理1个locker, 其可用容量和总容量为3-4

When LockerRobotDirector 查看报表

Then LockerRobotDirector 看到报表内容为
    
    M 2 3
        L 2 3
    M 3 4
        L 3 4	

7.Given LockerRobotDirector 管理一个 lockerRobotManager, lockerRobotManager
 管理两个locker, 两个locker的可用容量和总容量分别为: 2-3, 4-5, 没有管理robot, 存在一个不被lockerRobotManager管理的locker, 可用容量和总容量: 1-3

When LockerRobotDirector 查看报表

Then LockerRobotDirector 看到报表内容为

    M 6 8
        L 2 3
        L 4 5
