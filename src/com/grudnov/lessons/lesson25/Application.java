package com.grudnov.lessons.lesson25;



import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        SomeAccount account = new SomeAccount();

        ArrayList<IncrementTask> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new IncrementTask(account));
        }

        for (IncrementTask task: tasks){
            task.start();
        }

        for (IncrementTask task: tasks){
            try {
                task.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("Balance: " + account.getBalance());


    /*    Library library = new Library();
        new Thread(new PutThread(library)).start();
        new Thread(new PutThread(library)).start();
        new Thread(new PutThread(library)).start();
        new Thread(new GetThread(library)).start();*/

    }
}
