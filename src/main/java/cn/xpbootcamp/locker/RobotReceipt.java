package cn.xpbootcamp.locker;

public class RobotReceipt {
    private int lockerIndex;
    private Receipt receipt;

    public RobotReceipt(int lockerIndex, Receipt receipt) {
        this.lockerIndex = lockerIndex;
        this.receipt = receipt;
    }

    public int getLockerIndex() {
        return lockerIndex;
    }

    public Receipt getReceipt() {
        return receipt;
    }
}
