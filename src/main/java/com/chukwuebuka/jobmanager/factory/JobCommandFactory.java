package com.chukwuebuka.jobmanager.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.chukwuebuka.jobmanager.doman.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobCommandFactory {
    private Map<JobType, JobCommand> factories;

    @Autowired
    public JobCommandFactory(Set<JobCommand> delegateJobFactorySet){
        aggregateFactories(delegateJobFactorySet);
    }

    private void aggregateFactories(final Set<JobCommand> delegateJobFactorySet) {
        factories = new HashMap<>();
        delegateJobFactorySet.forEach(
                delegateJobFactory -> factories.put(delegateJobFactory.getJobType(), delegateJobFactory)
        );
    }

    public JobCommand getFactory(JobType jobType){
        return this.factories.get(jobType);
    }
}
