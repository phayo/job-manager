package com.chukwuebuka.jobmanager.doman;

import java.util.HashMap;

import lombok.Data;

@Data
public class JobParam {
    private int priority;
    private String getJobTriggerString;
    private JobState state;
    private HashMap<String, Object> otherParams;
}
