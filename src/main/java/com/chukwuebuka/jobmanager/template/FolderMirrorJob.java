package com.chukwuebuka.jobmanager.template;

import com.chukwuebuka.jobmanager.doman.Job;
import com.chukwuebuka.jobmanager.doman.JobParam;
import com.chukwuebuka.jobmanager.doman.JobState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Component
@Scope("prototype")
@Slf4j
public class FolderMirrorJob implements Job {
    private int priority;
    private JobState state;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

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

    @Override
    public JobParam getJobParam() {
        return null;
    }

    public Job instance() {
        return new FolderMirrorJob();
    }

    @Override
    public void run() {
        log.info("LoadingWorker.run() started.");
        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
        transactionTemplate.setReadOnly(true);

        transactionTemplate.execute(status -> {
            return null;
        });
        System.out.println("Running folder monitor job.");
    }
}
