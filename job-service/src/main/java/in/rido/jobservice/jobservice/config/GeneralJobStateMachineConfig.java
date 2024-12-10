package in.rido.jobservice.jobservice.config;

import in.rido.jobservice.jobservice.enums.JobEvent;
import in.rido.jobservice.jobservice.enums.JobState;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
public class GeneralJobStateMachineConfig extends StateMachineConfigurerAdapter<JobState, JobEvent> {

  @Override
  public void configure(StateMachineStateConfigurer<JobState, JobEvent> states) throws Exception {
    states
            .withStates()
            .initial(JobState.CREATED)
            .state(JobState.INITIATED)
            .state(JobState.IN_PROGRESS)
            .state(JobState.COMPLETED)
            .state(JobState.CANCELLED);
  }

  @Override
  public void configure(StateMachineTransitionConfigurer<JobState, JobEvent> transitions) throws Exception {
    transitions
            .withExternal().source(JobState.CREATED).target(JobState.INITIATED).event(JobEvent.CREATE_JOB)
            .and()
            .withExternal().source(JobState.INITIATED).target(JobState.IN_PROGRESS).event(JobEvent.INITIATE_JOB)
            .and()
            .withExternal().source(JobState.IN_PROGRESS).target(JobState.COMPLETED).event(JobEvent.COMPLETE_JOB)
            .and()
            .withExternal().source(JobState.CREATED).target(JobState.CANCELLED).event(JobEvent.CANCEL_JOB);
  }
}