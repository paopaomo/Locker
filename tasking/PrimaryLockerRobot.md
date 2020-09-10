### PrimaryLockerRobot

1. Given 有多个Locker, 均有空缺, When PrimaryLockerRobot 存包, Then 存入Locker1中, 打印小票, 存包成功
2. Given 有多个Locker, Locker1已满, Locker2有空缺, When PrimaryLockerRobot 存包, Then 存入Locker2中, 打印小票, 存包成功
3. Given 有多个Locker, 均已存满, When PrimaryLockerRobot 存包, Then 提示储物柜已满, 存包失败
4. Given 有效小票, When PrimaryLockerRobot 取包, Then 取到正确的包裹, 收回小票, 取包成功
5. Given 伪造小票, When PrimaryLockerRobot 取包, Then 提示小票不正确, 取包失败
