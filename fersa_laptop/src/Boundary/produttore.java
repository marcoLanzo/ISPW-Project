//package Boundary;
//
//import java.util.concurrent.Semaphore;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class produttore implements Runnable{
//
//    prova p = new prova();
//    private static Lock l = new ReentrantLock();
//
//
//    public void run(){
//
//          try {
//                  l.lock();
//                  p.k = p.k++;
//                  if (p.k >= 6)
//                      p.counterNotEmpty.signal();
//
//
//          } catch (Exception e) {
//              e.printStackTrace();
//          } finally {
//              l.unlock();
//          }
//      }
//
//}
