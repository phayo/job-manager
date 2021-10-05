package com.chukwuebuka.jobmanager.doman;

public interface Job extends Runnable{
    void updateState(JobState jobState);
    int getPriority();
    JobParam getJobParam();
}
