package ua.edu.sumdu.j2se.Myropolska.Anna.tasks;

import java.util.ArrayList;

public class ArrayTaskList {
    ArrayList<Task> tasks = new ArrayList<Task>();

    public void add(Task task) {
        tasks.add(task);
    }

    public boolean remove(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).equals(task)) {
                tasks.remove(i);
                return true;
            }
        }
        return false;

    }

    public int size() {
        return tasks.size();
    }

    public Task getTask(int index) {
        return tasks.get(index);

    }

    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList incoming = new ArrayTaskList();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).nextTimeAfter(from) >= 0) {
                if (tasks.get(i).nextTimeAfter(from) <= to)
                    incoming.add(tasks.get(i));

            }
        }
        return incoming;

        
    }

}

