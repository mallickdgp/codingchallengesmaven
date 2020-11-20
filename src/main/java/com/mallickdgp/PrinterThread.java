package com.mallickdgp;

public class PrinterThread {
    Storage storage = new Storage();

    public static void main(String[] args) {
        Storage storage = new Storage();
       CounterThread ct = new CounterThread(new Counter(), storage);
       Printer pt = new Printer(storage);

       ct.start();
       pt.start();


    }


}

class Storage{

    private Integer value;
    private Object lock = new Object();
    public Storage(){
        this.value = 0;
    }

        public Integer getValue () {
            return value;
        }

        public void setValue (Integer value){
            this.value = value;
        }

}

class Counter {

    public void count(Storage storage){
        int i=0;

        while(i<10){
            synchronized (new Object()) {
                storage.setValue(i);
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException iex) {
                }
            }
        }
    }
}

class CounterThread extends Thread{
    private Counter counter;
    private Storage storage;

    public CounterThread(Counter counter, Storage storage){
        this.counter = counter;
        this.storage = storage;
    }
    public void run(){
        this.counter.count(this.storage);
    }
}

class Printer extends Thread{
    private Storage storage;
    public Printer(Storage storage){
        this.storage = storage;
    }
    public void run(){
       print();

    }

    private void print(){
        int currVal = 0;

        while(currVal<9) {
            synchronized (new Object()) {
                System.out.println(storage.getValue());
                currVal = storage.getValue();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException iex) {

                }
            }
        }
    }


}


