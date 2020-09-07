### Locker

1. Given Locker有空缺, When 用户存包, Then Locker打印小票, 用户存包成功
2. Given Locker无空缺, When 用户存包, Then Locker提示储物柜已满, 用户存包失败
3. Given 用户拥有有效小票, When 用户取包, Then Locker打开对应包裹的柜门, 用户取包成功
4. Given 用户拥有伪造小票, When 用户取包, Then Locker提示小票不正确, 用户取包失败
3. Given 用户拥有已使用小票, When 用户取包, Then Locker提示已经取过包, 用户取包失败

### PrimaryLockerRobot

1. Given 有多个Locker, 均有空缺, When PrimaryLockerRobot 存包, Then 存入Locker1中, 打印小票, 存包成功
2. Given 有多个Locker, Locker1已满, Locker2有空缺, When PrimaryLockerRobot 存包, Then 存入Locker2中, 打印小票, 存包成功
3. Given 有多个Locker, 均已存满, When PrimaryLockerRobot 存包, Then 提示储物柜已满, 存包失败
4. Given 有效小票, When PrimaryLockerRobot 取包, Then 取到正确的包裹, 收回小票, 取包成功
5. Given 伪造小票, When PrimaryLockerRobot 取包, Then 提示小票不正确, 取包失败

### SmartLockerRobot

1. Given locker1有10个空缺, locker2有3个空缺, When SmartLockerRobot 存包, Then 存入 locker1中, 打印小票, 存包成功
2. Given locker1有3个空缺, locker2有10个空缺, When SmartLockerRobot 存包, Then 存入 locker2中, 打印小票, 存包成功
3. Given locker1有3个空缺, locker2有3个空缺, When SmartLockerRobot 存包, Then 存入 locker1中, 打印小票, 存包成功
4. Given locker1, locker2 均无空缺, When SmartLockerRobot 存包, Then 提示储物柜已满, 存包失败
5. Given 有效小票, When SmartLockerRobot 取包, Then 取到正确的包裹, 收回小票, 取包成功
6. Given 伪造小票, When SmartLockerRobot 取包, Then 提示小票不正确, 取包失败

### LockerRobotManager

##### 存包
1. 
Given LockerRobotManager 管理两个robot(robot1, robot2),且两个robot管理的locker均有可用容量,没有管理locker
When LockerRobotManager存包
Then 由robot1存入,打印小票,存包成功
2. 
Given LockerRobotManager 管理两个robot(robot1, robot2),robot1管理的locker已满,robot2管理的locker有可用容量,没有管理locker
When LockerRobotManager存包
Then 由robot2存入,打印小票,存包成功
3.
Given LockerRobotManager 管理两个robot(robot1, robot2),且两个robot管理的locker均无可用容量,没有管理locker
When LockerRobotManager存包
Then 提示储物柜已满,存包失败
4.
Given LockerRobotManager 管理两个locker,且均有可用容量,没有管理robot
When LockerRobotManager存包
Then 存入locker1中,打印小票,存包成功
5.
Given LockerRobotManager 管理两个locker,locker1已满,locker2有可用容量,没有管理robot
When LockerRobotManager存包
Then 存入locker2中,打印小票,存包成功
6.
Given LockerRobotManager 管理两个locker,且均无可用容量,没有管理robot
When LockerRobotManager存包
Then 提示储物柜已满,存包失败
7.
Given LockerRobotManager 管理一个robot,robot管理的locker有可用容量,管理一个locker,该locker有可用容量
When LockerRobotManager存包
Then 由robot存入,打印小票,存包成功
8. 
Given LockerRobotManager 管理一个robot,robot管理的locker无可用容量,管理一个locker,该locker有可用容量
When LockerRobotManager存包
Then 存入locker中,打印小票,存包成功
9. 
Given LockerRobotManager 管理一个robot,robot管理的locker无可用容量,管理一个locker,该locker无可用容量
When LockerRobotManager存包
Then 提示储物柜已满,存包失败

##### 取包
1.
Given LockerRobotManager 管理两个robot,没有管理locker,且小票有效
When LockerRobotManager取包
Then 取出正确的包裹,取包成功
2.
Given LockerRobotManager 管理两个robot,没有管理locker,且小票无效
When LockerRobotManager取包
Then 提示小票不正确, 取包失败
3.
Given LockerRobotManager 管理两个locker,没有管理robot,且小票有效
When LockerRobotManager取包
Then 取出正确的包裹,取包成功
4.
Given LockerRobotManager 管理两个locker,没有管理robot,且小票无效
When LockerRobotManager取包
Then 提示小票不正确, 取包失败
5.
Given LockerRobotManager 管理一个robot,一个locker,且小票有效
When LockerRobotManager取包
Then 取出正确的包裹,取包成功
6.
Given LockerRobotManager 管理一个robot,一个locker,且小票无效
When LockerRobotManager取包
Then 提示小票不正确, 取包失败
