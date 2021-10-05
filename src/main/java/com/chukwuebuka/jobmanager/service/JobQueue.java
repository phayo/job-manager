package com.chukwuebuka.jobmanager.service;

import com.chukwuebuka.jobmanager.doman.Job;
import org.springframework.stereotype.Service;

@Service
public interface JobQueue {
    void offer(Job job);
    Job poll();
    boolean isEmpty();
}
