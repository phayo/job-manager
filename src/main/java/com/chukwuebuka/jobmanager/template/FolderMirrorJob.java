package com.chukwuebuka.jobmanager.template;

import com.chukwuebuka.jobmanager.doman.Job;
import com.chukwuebuka.jobmanager.doman.JobParam;
import com.chukwuebuka.jobmanager.doman.JobState;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FolderMirrorJob implements Job {
    private int priority;
    private JobState state;

    @Override
    public void updateState(final JobState jobState) {
        this.state = jobState;
    }

    void setParams(final JobParam jobParam){
        this.priority = jobParam.getPriority();
        this.state = jobParam.getState();
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    public Job instance() {
        return new FolderMirrorJob();
    }

    @Override
    public void run() {
        System.out.println("Running folder monitor job.");
    }
}
