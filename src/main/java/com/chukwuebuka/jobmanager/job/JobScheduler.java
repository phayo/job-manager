package com.chukwuebuka.jobmanager.job;

import java.util.LinkedList;
import java.util.List;

import com.chukwuebuka.jobmanager.doman.Job;
import com.chukwuebuka.jobmanager.queue.DefaultJobQueueProvider;
import org.springframework.stereotype.Service;

@Service
public class JobScheduler {
    private DefaultJobQueueProvider queue;
    private List<Job> jobs = new LinkedList<>();

    private JobScheduler(final DefaultJobQueueProvider queue) {
        this.queue = queue;
    }

    private void scheduleInstantly(Job jobToSchedule){
        queue.offer(jobToSchedule);
    }

    private void scheduleLater(Job jobToSchedule, String cronExpression){

    }
}
