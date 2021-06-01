package com.chukwuebuka.jobmanager.queue;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

import com.chukwuebuka.jobmanager.doman.Job;
import com.chukwuebuka.jobmanager.job.JobQueue;

public class DefaultJobQueueProvider implements JobQueue {
    private static final int DEFAULT_QUEUE_CAPACITY = 10;
    private final PriorityBlockingQueue<Job> taskQueue
            = new PriorityBlockingQueue<>(DEFAULT_QUEUE_CAPACITY, Comparator.comparingInt(Job::getPriority));


    public void offer(Job job){
        this.taskQueue.offer(job);
    }

    public Job poll(){
        return this.taskQueue.poll();
    }
}
