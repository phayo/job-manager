package com.chukwuebuka.jobmanager.factory;

import java.util.Optional;
import java.util.Set;

import com.chukwuebuka.jobmanager.doman.Job;
import com.chukwuebuka.jobmanager.doman.JobParam;
import com.chukwuebuka.jobmanager.doman.JobType;
import org.springframework.stereotype.Component;

@Component
public interface JobCommand {
    JobType getJobType();
    Job getSpecificJobCommand();
    Optional<String> validateInputParameters(final JobParam inputParams);
    Set<Job> getJobInstances();
}
