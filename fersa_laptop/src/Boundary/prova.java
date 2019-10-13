//package Boundary;
//
//import java.util.Date;
//import java.util.concurrent.Semaphore;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Condition;
//
//public class prova {
//
//    protected int k;
//    consumatore consumer;
//    produttore producer;
//    Thread t;
//    Thread t2;
//
//
//    Condition counterEmpty = new Condition() {
//        @Override
//        public void await() throws InterruptedException {
//
//        }
//
//        @Override
//        public void awaitUninterruptibly() {
//
//        }
//
//        @Override
//        public long awaitNanos(long nanosTimeout) throws InterruptedException {
//            return 0;
//        }
//
//        @Override
//        public boolean await(long time, TimeUnit unit) throws InterruptedException {
//            return false;
//        }
//
//        @Override
//        public boolean awaitUntil(Date deadline) throws InterruptedException {
//            return false;
//        }
//
//        @Override
//        public void signal() {
//
//        }
//
//        @Override
//        public void signalAll() {
//
//        }
//    };
//    Condition counterNotEmpty = new Condition() {
//        @Override
//        public void await() throws InterruptedException {
//
//        }
//
//        @Override
//        public void awaitUninterruptibly() {
//
//        }
//
//        @Override
//        public long awaitNanos(long nanosTimeout) throws InterruptedException {
//            return 0;
//        }
//
//        @Override
//        public boolean await(long time, TimeUnit unit) throws InterruptedException {
//            return false;
//        }
//
//        @Override
//        public boolean awaitUntil(Date deadline) throws InterruptedException {
//            return false;
//        }
//
//        @Override
//        public void signal() {
//
//        }
//
//        @Override
//        public void signalAll() {
//
//        }
//    };
//
//    for(int i = 0; i < 6; i++)
//
//    {
//
//        consumer = new consumatore();
//        t = new Thread(consumer);
//        t.start();
//
//    }
//
//    for(int j = 0; j< 6; j++)
//
//    {
//        producer = new produttore();
//        t2 = new Thread(producer);
//        t2.start();
//    }
//
//
//}
