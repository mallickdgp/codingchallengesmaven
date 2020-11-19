package com.mallickdgp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServicePractise {
    public static void main(String[] args) {
        final List<TaskSimul> tasks = new ArrayList<>();
        TaskSimul task1 = new TaskSimul("t1", null);
        TaskSimul task2 = new TaskSimul("t2", null);
        List<TaskSimul> t3Dependencies = new ArrayList<>();
        t3Dependencies.add(task1);
        t3Dependencies.add(task2);
        TaskSimul task3 = new TaskSimul("t3", t3Dependencies);
        TaskSimul task4 = new TaskSimul("t4", null);
        TaskSimul task5 = new TaskSimul("t5", null);
        List<TaskSimul> t6Dependencies = new ArrayList<>();
        t6Dependencies.add(task4);
        t6Dependencies.add(task5);
        TaskSimul task6 = new TaskSimul("t6", t6Dependencies);

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);
        solution(tasks);
    }

    public static void solution(final List<TaskSimul> tasks) {

        ExecutorService service = Executors.newFixedThreadPool(4);

        for (TaskSimul task : tasks) {
            service.submit(() -> {
                while (!task.isCompleted()) {
                    System.out.println("Current Thread " + task.getName());
                    boolean canExecute = false;
                    if (task.getDependencies() == null)
                        canExecute = true;
                    else {
                        System.out.println("Checking dependencies");
                        for (TaskSimul depTask : task.getDependencies()) {
                            if (depTask.isCompleted())
                                canExecute = true;
                            else
                                canExecute = false;
                        }
                    }
                    if (canExecute) {
                        task.execute();
                        System.out.println(task.getName());
                    } else {
                        System.out.println("Putting " + task.getName() + " to sleep");
                        try {
                            Thread.sleep(4000);

                        } catch (InterruptedException iex) {

                        }
                    }
                }
            });


        }

        service.shutdown();


    }
}

class TaskSimul {
    private String name;
    private List<TaskSimul> dependencies;
    private boolean completed;

    public String getName() {
        return name;
    }

    public List<TaskSimul> getDependencies() {
        return dependencies;
    }

    public boolean isCompleted() {
        return completed;
    }

    public TaskSimul(String name, List<TaskSimul> dependencies) {
        this.name = name;
        this.dependencies = dependencies;
        this.completed = false;

    }

    public void execute() {
        try {
            Thread.sleep(5000);
            this.completed = true;
        } catch (InterruptedException iex) {

        }
    }


}
