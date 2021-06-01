package com.chukwuebuka.jobmanager.factory;

import com.chukwuebuka.jobmanager.doman.Job;
import com.chukwuebuka.jobmanager.doman.JobType;
import com.chukwuebuka.jobmanager.template.FolderMirrorJob;
import org.springframework.beans.factory.annotation.Lookup;

public class FolderMirrorFactory implements JobFactorySpec {
    @Override
    public JobType getJobType() {
        return JobType.FOLDER_MIRROR;
    }

    @Override
    @Lookup
    public FolderMirrorJob getInstance() {
        return null;
    }
}
