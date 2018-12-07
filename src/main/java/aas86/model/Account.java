package aas86.model;


public class Account {


    private String ownerName;
    private int money;

    public Account(String ownerName, int money) {
        this.ownerName = ownerName;
        this.money = money;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
