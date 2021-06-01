package com.chukwuebuka.jobmanager.doman;

import java.util.HashMap;

import lombok.Data;

@Data
public class JobParam {
    private int priority;
    private JobState state;
    private HashMap<String, Object> otherParams;
}
