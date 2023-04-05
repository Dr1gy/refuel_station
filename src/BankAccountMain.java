public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Иванов", 1000);
        BankAccount account2 = new BankAccount("Петров", 500);

        System.out.println("У " + account1.getOwner() + " на счету " + account1.getBalance() + " рублей");
        System.out.println("У " + account2.getOwner() + " на счету " + account2.getBalance() + " рублей");

        account1.transfer(account2, 500);

        System.out.println("У " + account1.getOwner() + " на счету " + account1.getBalance() + " рублей после перевода");
        System.out.println("У " + account2.getOwner() + " на счету " + account2.getBalance() + " рублей после перевода");

        account1.merge(account2);

        System.out.println("У " + account1.getOwner() + " на счету " + account1.getBalance() + " рублей после объединения");
        System.out.println("У " + account2.getOwner() + " на счету " + account2.getBalance() + " рублей после объединения");
    }

}
