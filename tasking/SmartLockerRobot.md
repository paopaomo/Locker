### SmartLockerRobot

1. Given locker1有10个空缺, locker2有3个空缺, When SmartLockerRobot 存包, Then 存入 locker1中, 打印小票, 存包成功
2. Given locker1有3个空缺, locker2有10个空缺, When SmartLockerRobot 存包, Then 存入 locker2中, 打印小票, 存包成功
3. Given locker1有3个空缺, locker2有3个空缺, When SmartLockerRobot 存包, Then 存入 locker1中, 打印小票, 存包成功
4. Given locker1, locker2 均无空缺, When SmartLockerRobot 存包, Then 提示储物柜已满, 存包失败
5. Given 有效小票, When SmartLockerRobot 取包, Then 取到正确的包裹, 收回小票, 取包成功
6. Given 伪造小票, When SmartLockerRobot 取包, Then 提示小票不正确, 取包失败
