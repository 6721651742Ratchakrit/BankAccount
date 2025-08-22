public class Depositor implements Runnable {
    BankAccount tmp ;
    long value ;
    int round ;

    public Depositor (BankAccount tmp, long value ,int round){
        this.tmp = tmp ;
        this.value = value ;
        this.round = round ;
    }
    @Override
    public void run() {
        for (int i = 0; i < round; i++) {
            tmp.deposit(value);
        }
    }
}
