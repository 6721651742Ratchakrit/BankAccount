public class BankAccount {
    private long balance ;

    public synchronized void deposit(long amount){
        balance += amount ;
    }
    public synchronized void withdraw(long amount){
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public long getBalance(){
        return this.balance;
    }
}
