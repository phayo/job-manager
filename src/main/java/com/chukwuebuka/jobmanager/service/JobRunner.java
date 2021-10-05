package com.chukwuebuka.jobmanager.service;

import java.text.SimpleDateFormat;
import java.util.concurrent.ScheduledFuture;

import com.chukwuebuka.jobmanager.doman.Job;
import com.chukwuebuka.jobmanager.doman.JobState;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JobRunner {
    private static final Logger log = LoggerFactory.getLogger(JobRunner.class);
    private final JobQueue queue;
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
    private final TaskScheduler scheduler;

    public JobRunner(final JobQueue queue, final TaskScheduler scheduler) {this.queue = queue;
        this.scheduler = scheduler;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runJobs(){
        while(true){
            if(!this.queue.isEmpty()){
                delegateRun(this.queue.poll());
            }
        }
    }

    private void delegateRun(Job job){
        String triggerString = job.getJobParam().getGetJobTriggerString();
        try{
            if(idDateTrigger(triggerString)){
                scheduler.schedule(job, dateFormatter.parse(triggerString);
            } else if (isCronTriggerString(triggerString)){
                scheduler.schedule(job, new CronTrigger(triggerString));
            }
        }catch (Exception e){
            log.info("Exception occurred while running");

        }

    }
}
