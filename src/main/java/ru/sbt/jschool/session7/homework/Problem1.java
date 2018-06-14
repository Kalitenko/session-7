package ru.sbt.jschool.session7.homework;

public class Problem1 {
    public static void main(String[] args) {
        MyThreadProblem1 myThreadProblem1 = new MyThreadProblem1(1);
    }
}

class MyThreadProblem1 implements Runnable{

    private int idx;
    private Thread thread;
    private String msg = "Hello from Thread - ";

    public MyThreadProblem1(int idx) {
        this.idx = idx;
        this.msg = msg + idx;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        if(idx < 50){
            MyThreadProblem1 myThread = new MyThreadProblem1(idx + 1);

            try {
                myThread.thread.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(msg);
    }
}