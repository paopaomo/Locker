### Locker

1. Given Locker有空缺, When 用户存包, Then Locker打印小票, 用户存包成功
2. Given Locker无空缺, When 用户存包, Then Locker提示储物柜已满, 用户存包失败
3. Given 用户拥有有效小票, When 用户取包, Then Locker打开对应包裹的柜门, 用户取包成功
4. Given 用户拥有伪造小票, When 用户取包, Then Locker提示小票不正确, 用户取包失败
3. Given 用户拥有已使用小票, When 用户取包, Then Locker提示已经取过包, 用户取包失败
