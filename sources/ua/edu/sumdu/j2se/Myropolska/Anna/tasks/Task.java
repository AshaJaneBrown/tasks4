package ua.edu.sumdu.j2se.Myropolska.Anna.tasks;

public class Task {
    /**
    * Task class contains information about tasks to be implemented
    * and is the basis for task manager application 
    */
    private String title;
    private int time;
    private boolean isActive;
    private int start;
    private int end;
    private int interval;
    private boolean isRepeated;

    public Task(String title, int time) {
    /**
    * Task constructor with the following parameters (String, int)
    */
        this.title = title;
        this.time = time;
        this.isActive = false;
        this.isRepeated = false;
    }

    public Task(String title, int start, int end, int interval) {
    /**
    * Task constructor with the following parameters (int, int, int)
    */
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.isActive = false;
        this.isRepeated = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getTime() {
        if (this.isRepeated())
            return start;
        else
            return time;
    }

    public void setTime(int time) {
        this.time = time;
        if (this.isRepeated())
            this.isRepeated = false;
    }
    public int getStartTime() {
        if (this.isRepeated())
            return start;
        else
            return time;
    }
    public int getEndTime() {
        if (this.isRepeated())
            return end;
        else
            return time;
    }
    public int getRepeatInterval() {
        if (this.isRepeated())
            return interval;
        else
            return 0;
    }
    public void setTime(int start, int end, int interval) {
        this.start = start;
        this.end = end;
        this.interval = interval;
        if (!this.isRepeated())
            this.isRepeated = true;
    }
    public boolean isRepeated() {
        return isRepeated;
    }

    public int nextTimeAfter(int current) {
    /**
    * A method to define the next time when the task will be implemented
    */
        if (!this.isActive()) {
            return -1;
        } else {
            if (!isRepeated()) {
                if (current < time)
                    return time;
                else
                    return -1;
            } else {
                if (current < start) {
                    return start;
                } else {
                    if (current > end) {
                            return -1;
                    } else {
                        int period = end - start;
                        int generalNumberOfIntervals = period / interval;
                        /**
                        * The general number of intervals of a repeated task
                        * that fits into indicated period
                        */
                        int numberOfIntervalsBeforeCurrent = (current - start)
                        / interval;
                        /**
                        * Tne number of time intervals that has passed  
                        * before the current time
                        */
                            if (current >= (generalNumberOfIntervals * interval
                            + start)) {
                                return -1;
                            /**
                            * Checking whether all the time intervals possible
                            * have already passed
                            */
                            } else {
                                return (((numberOfIntervalsBeforeCurrent + 1) 
                            * interval) + start);
                            }
                            /**
                            * Defing and returning the start time 
                            * of the next interval 
                            */
                    }
                        
                }
            }
        }
    }
}