//package Boundary;
//
//import java.util.concurrent.Semaphore;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class consumatore implements Runnable {
//
//    prova p = new prova();
//    private static Lock lock = new ReentrantLock();
//
//
//    public void run() {
//
//        try {
//            lock.lock();
//            while (p.k < 6)
//                p.counterNotEmpty.await();
//
//
//            p.k = p.k - 6;
//
//            if (p.k < 6)
//                p.counterEmpty.signal();
//
//
//            Thread.sleep(50000); //auto-sospensione del thread
//        }
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//    }
//}
