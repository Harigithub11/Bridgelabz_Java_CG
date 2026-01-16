package objectoriented.objectmodeling.level1;

class BankAssociation {
    String bankName = "ABC Bank";
    String customerName = "Hari";
    double balance = 5000;

    void openAccount() {
        System.out.println(customerName + " opened account in " + bankName);
    }

    void viewBalance() {
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAssociation obj = new BankAssociation();
        obj.openAccount();
        obj.viewBalance();
    }
}
