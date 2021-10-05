package com.chukwuebuka.jobmanager.service;

import java.util.LinkedList;
import java.util.List;

import com.chukwuebuka.jobmanager.doman.Job;
import org.springframework.stereotype.Service;

@Service
public class JobScheduler {
    private JobQueue queue;
    private final List<Job> jobs = new LinkedList<>();

    private JobScheduler(final JobQueue queue) {
        this.queue = queue;
    }

    private void schedule(Job jobToSchedule){
        jobs.add(jobToSchedule);
        queue.offer(jobToSchedule);
    }
}
