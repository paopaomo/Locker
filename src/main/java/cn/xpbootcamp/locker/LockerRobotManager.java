package cn.xpbootcamp.locker;

import java.util.List;

public class LockerRobotManager {
    final private List<Storable> storables;

    public LockerRobotManager(List<Storable> storables) {
        this.storables = storables;
    }

    public Receipt saveBag(Bag bag) {
        for(Storable storable: storables) {
            if(storable.hasAvailableCapacity()) {
                return storable.saveBag(bag);
            }
        }
        throw  new LockerIsFullException();
    }

    public Bag takeBag(Receipt receipt) {
        for(Storable storable: storables) {
            if(storable.existedReceipt(receipt)) {
                return storable.takeBag(receipt);
            }
        }
        throw new ReceiptIsInvalidException();
    }
}
