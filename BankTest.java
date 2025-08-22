import java.util.ArrayList;

public class BankTest {
    public static void main(String[] args) {
        BankAccount A = new BankAccount();
        ArrayList<Thread> t = new ArrayList<>();
        int NUM_DEPOSITOR = 3 ;
        int NUM_WITHDRAWER = 3 ;
        int VALUE = 100 ;
        int ROUND = 10000 ;
        //สร้างคนฝาก
        for (int i = 0; i < NUM_DEPOSITOR; i++) {
            Thread x = new Thread(new  Depositor(A, VALUE, ROUND));
            t.add(x);
        }
        //สร้างคนถอน
        for (int i = 0; i < NUM_WITHDRAWER; i++) {
            Thread z = new Thread(new Withdrawer(A, VALUE, ROUND));
            t.add(z);
        }
        //สั่งทำงาน
        for (Thread thread : t) {
            thread.start();
        }
        //ทำงานจนเสร็จ
        try {
            for (Thread thread : t) {
                thread.join();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Expected Value : "+(NUM_DEPOSITOR-NUM_WITHDRAWER)*VALUE*ROUND);
        System.out.println("Real Value : "+A.getBalance());
    }
}
