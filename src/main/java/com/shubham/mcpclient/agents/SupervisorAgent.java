package com.shubham.mcpclient.agents;

import org.springframework.stereotype.Component;

@Component
public class SupervisorAgent {

    private final PlannerAgent plannerAgent;
    private final ExecutorAgent executorAgent;


    public SupervisorAgent (PlannerAgent plannerAgent, ExecutorAgent executorAgent) {
        this.plannerAgent = plannerAgent;
        this.executorAgent = executorAgent;
    }

    public String coordinate(String userInput){

        String plan=plannerAgent.createPlan(userInput);
        return executorAgent.execute(plan,userInput);
    }}
