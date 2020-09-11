### LockerRobotManager

##### 存包
1.Given LockerRobotManager 管理两个robot(robot1, robot2),且两个robot管理的locker均有可用容量,没有管理locker

When LockerRobotManager存包

Then 由robot1存入,打印小票,存包成功

2.Given LockerRobotManager 管理两个robot(robot1, robot2),robot1管理的locker已满,robot2管理的locker有可用容量,没有管理locker

When LockerRobotManager存包

Then 由robot2存入,打印小票,存包成功

3.Given LockerRobotManager 管理两个robot(robot1, robot2),且两个robot管理的locker均无可用容量,没有管理locker

When LockerRobotManager存包

Then 提示储物柜已满,存包失败

4.Given LockerRobotManager 管理两个locker,且均有可用容量,没有管理robot

When LockerRobotManager存包

Then 存入locker1中,打印小票,存包成功

5.Given LockerRobotManager 管理两个locker,locker1已满,locker2有可用容量,没有管理robot

When LockerRobotManager存包

Then 存入locker2中,打印小票,存包成功

6.Given LockerRobotManager 管理两个locker,且均无可用容量,没有管理robot

When LockerRobotManager存包

Then 提示储物柜已满,存包失败

7.Given LockerRobotManager 管理一个robot,robot管理的locker有可用容量,管理一个locker,该locker有可用容量

When LockerRobotManager存包

Then 由robot存入,打印小票,存包成功

8.Given LockerRobotManager 管理一个robot,robot管理的locker无可用容量,管理一个locker,该locker有可用容量

When LockerRobotManager存包

Then 存入locker中,打印小票,存包成功

9.Given LockerRobotManager 管理一个robot,robot管理的locker无可用容量,管理一个locker,该locker无可用容量

When LockerRobotManager存包

Then 提示储物柜已满,存包失败

##### 取包
1.Given LockerRobotManager 管理两个robot,没有管理locker,且小票有效

When LockerRobotManager取包

Then 取出正确的包裹,取包成功

2.Given LockerRobotManager 管理两个robot,没有管理locker,且小票无效

When LockerRobotManager取包

Then 提示小票不正确, 取包失败

3.Given LockerRobotManager 管理两个locker,没有管理robot,且小票有效

When LockerRobotManager取包

Then 取出正确的包裹,取包成功

4.Given LockerRobotManager 管理两个locker,没有管理robot,且小票无效

When LockerRobotManager取包

Then 提示小票不正确, 取包失败

5.Given LockerRobotManager 管理一个robot,一个locker,且小票有效

When LockerRobotManager取包

Then 取出正确的包裹,取包成功

6.Given LockerRobotManager 管理一个robot,一个locker,且小票无效

When LockerRobotManager取包

Then 提示小票不正确, 取包失败
