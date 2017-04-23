package sync;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zgl
 * Date: 2017/4/23.
 * Email: gaoleizhou@gmail.com
 */
public class Bank {
    //银行账户数量
    private final double[] accounts;

    //可重入锁
    private ReentrantLock bankLock;

    //锁的条件Condition
    private Condition sufficientFundsCondition;

    /**
     * 构造函数
     * @param n 账户数量
     * @param initialBalance 账户初始化金额
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFundsCondition = bankLock.newCondition();
    }

    /**
     * 转账
     * @param from 转出账户
     * @param to 转入账户
     * @param amount 转出金额
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                //条件阻塞
                sufficientFundsCondition.await();
            }

            if (accounts[from] < amount) return;
            System.out.println(Thread.currentThread());
            accounts[from] = accounts[from] - amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] = accounts[to] + amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            //解除条件阻塞
            sufficientFundsCondition.signalAll();
        }
        finally{
            bankLock.unlock();
        }
    }

    /**
     * 获取银行总资金
     * @return 银行总资金
     */
    public double getTotalBalance() {
        double sum = 0;
        for(double account : accounts) {
            sum = sum + account;
        }
        return sum;
    }

    /**
     * 获取银行账户数量
     * @return 银行账户数量
     */
    public int size() {
        return accounts.length;
    }

}
