package com.chukwuebuka.jobmanager.doman;

import lombok.Data;

@Data
public class JobRunSpecification {
    private JobType jobType;
    private JobParam jobParameters;
    private JobRunSchedule jobRunSchedule;
    private int priority;
}
