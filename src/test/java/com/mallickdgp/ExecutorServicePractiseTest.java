package com.mallickdgp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExecutorServicePractiseTest {

    @Test
    public void testExecutor(){
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
        t3Dependencies.add(task4);
        t3Dependencies.add(task5);
        TaskSimul task6 = new TaskSimul("t6", t6Dependencies);

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);
        ExecutorServicePractise.solution(tasks);
    }
}
