package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public abstract class Robot {
    protected final List<Locker> lockers;

    public Robot(ArrayList<Locker> lockers) {
        this.lockers = lockers;
    }

    public abstract Receipt saveBag(Bag bag);

    public Bag takeBag(Receipt receipt) {
        for(Locker locker: lockers) {
            if(locker.existedReceipt(receipt)) {
                return locker.takeBag(receipt);
            }
        }
        throw new ReceiptIsInvalidException();
    }
}
