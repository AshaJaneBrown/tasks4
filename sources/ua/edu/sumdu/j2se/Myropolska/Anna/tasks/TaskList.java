package ua.edu.sumdu.j2se.Myropolska.Anna.tasks;

import java.util.Iterator;

abstract public class TaskList implements Iterable{

    public int size;

    abstract void add(Task task);

    abstract public boolean remove(Task task);

    abstract public Task getTask(int index);

    abstract public Iterator iterator();

    abstract public TaskList createList(int from, int to);


    public int size() {
        return size;
    }

    public TaskList incoming(int from, int to) {
        TaskList incoming = createList(from, to);
        return incoming;
    }


}