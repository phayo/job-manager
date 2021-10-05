package com.chukwuebuka.jobmanager.factory;

import java.util.Optional;
import java.util.Set;

import com.chukwuebuka.jobmanager.doman.Job;
import com.chukwuebuka.jobmanager.doman.JobParam;
import com.chukwuebuka.jobmanager.doman.JobType;
import com.chukwuebuka.jobmanager.template.FolderMirrorJob;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class FolderMirrorCommand implements JobCommand {
    @Override
    public JobType getJobType() {
        return JobType.FOLDER_MIRROR;
    }

    @Override
    @Lookup
    public FolderMirrorJob getSpecificJobCommand() {
        return null;
    }

    @Override
    public Optional<String> validateInputParameters(final JobParam inputParams) {
        return Optional.empty();
    }

    @Override
    public Set<Job> getJobInstances() {
        return null;
    }
}
