package com.mallickdgp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TwilioChallenge2 {
}

interface Task2 {

        String getName();

      //  Collection<Task2> getDependencies();

        int execute();

        boolean isCompleted();
        }

class TaskResult {

    final String name;
    final int result;

    TaskResult(final String name, final int result) {
        this.name = name;
        this.result = result;
    }
}

class TaskExecutor {

    /*
     * Complete the 'execute' function below.
     *
     * The function is expected to return a list of task execution results.
     * The function accepts a collection of tasks as parameter.
     */

    public List<TaskResult> execute(final Collection<Task2> tasks) {
        // TODO: implement
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        final List<TaskResult> taskResults = new ArrayList<>();
        for(Task2 task : tasks){

            executorService.submit(() -> {
                try {
                    int result = task.execute();
                    TaskResult taskResult = new TaskResult(task.getName(), result);
                    taskResults.add(taskResult);
                }catch (RuntimeException rex){

                }
            });
        }
        return taskResults;
    }


}


