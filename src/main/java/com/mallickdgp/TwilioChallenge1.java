package com.mallickdgp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TwilioChallenge1 {
}
final class NoCapacityException extends Exception {
    public NoCapacityException() {
        super();
    }
}

interface Task {
    String getTag();
    int getSlots();
    void runOneCycle();
    boolean isCompleted();
}

interface Worker {
    int getAvailableSlots();

    /**
     * Accepts a task for execution. An exception is thrown if there are insufficient processing slots.
     */
    void add(Task task) throws NoCapacityException;

    /**
     * @return list of tasks that have completed at the end of this cycle
     */
    List<Task> runCycle();
}
interface TaskPlacement {
    List<Task> getPendingTasks();
    List<Task> getRunningTasks();
    List<Task> getCompletedTasks();
    void assignTasksForNextCycle();
    void tasksCompletedOnWorker(List<Task> completedTasks, Worker worker);
}
final class TaskPlacementImpl implements TaskPlacement {
    private final List<Worker> workers;
    private final List<Task> tasks;
    private final List<Task> completedTasks;
    private final List<Task> runningTasks;
    private final List<Task> pendingTasks;
    public TaskPlacementImpl(final List<Worker> workers, final List<Task> tasks) {
        //Write your code here
        this.workers = workers;
        this.tasks = tasks;
        this.pendingTasks = tasks;
        this.completedTasks = new ArrayList<>();
        this.runningTasks = new ArrayList<>();
    }

    @Override
    public List<Task> getPendingTasks() {
        //Write your code here
      return pendingTasks;
    }

    @Override
    public List<Task> getRunningTasks() {
        //Write your code here
     return runningTasks;

    }

    @Override
    public List<Task> getCompletedTasks() {
        //Write your code here
      return completedTasks;
    }

    @Override
    public void assignTasksForNextCycle() {
        //Write your code here
        for(Task task : tasks){
            for(Worker worker : workers){
                if(task.getSlots() <= worker.getAvailableSlots()) {
                    try {
                        worker.add(task);
                        runningTasks.add(task);
                        pendingTasks.remove(task);
                    }catch (NoCapacityException ncx){
                        System.out.println(ncx.getMessage());
                    }
                }
            }

        }
    }

    @Override
    public void tasksCompletedOnWorker(final List<Task> completedTasks, final Worker worker) {
        //Write your code here
        this.completedTasks.addAll(completedTasks);
       this.tasks.removeAll(completedTasks);
       this.runningTasks.removeAll(completedTasks);
       int index = this.workers.indexOf(worker);
        this.workers.set(index, worker);
    }

    // ..
    // Write your extra methods here
    // ..
}
 final class WorkerImpl implements Worker{
    private final AtomicInteger availableSlots;
    private final List<Task> runningTasks;

    public WorkerImpl(final int capacity) {
        this.availableSlots = new AtomicInteger(capacity);
        this.runningTasks = new ArrayList<>(capacity);
    }

    @Override
    public int getAvailableSlots() {
        return availableSlots.get();
    }

    @Override
    public void add(final Task task) throws NoCapacityException {
        if (availableSlots.get() - task.getSlots() < 0) {
            throw new NoCapacityException();
        }
        runningTasks.add(task);
        availableSlots.addAndGet(-task.getSlots());
    }

    @Override
    public List<Task> runCycle() {
        final List<Task> completedTasks = new ArrayList<>();
        for (final Task task : runningTasks) {
            task.runOneCycle();
            if (task.isCompleted()) {
                completedTasks.add(task);
                availableSlots.addAndGet(task.getSlots());
            }
        }
        runningTasks.removeAll(completedTasks);
        return completedTasks;
    }
}
