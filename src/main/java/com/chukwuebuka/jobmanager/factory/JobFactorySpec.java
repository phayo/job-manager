package com.chukwuebuka.jobmanager.factory;

import com.chukwuebuka.jobmanager.doman.Job;
import com.chukwuebuka.jobmanager.doman.JobType;

public interface JobFactorySpec {
    JobType getJobType();
    Job getInstance();
}
