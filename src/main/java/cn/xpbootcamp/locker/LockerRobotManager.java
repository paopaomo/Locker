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

    public int getAvailableCapacity() {
        int availableCapacity = 0;
        for(Storable storable: storables) {
            availableCapacity += storable.getAvailableCapacity();
        }
        return availableCapacity;
    }

    public int getCapacity() {
        int capacity = 0;
        for(Storable storable: storables) {
            capacity += storable.getCapacity();
        }
        return capacity;
    }

    public StringBuilder getReport() {
        StringBuilder info = new StringBuilder("M " + getAvailableCapacity() + " " + getCapacity());
        for(Storable storable: storables) {
            info.append("\n").append("\t").append(storable.getReport());
        }
        return info;
    }
}
