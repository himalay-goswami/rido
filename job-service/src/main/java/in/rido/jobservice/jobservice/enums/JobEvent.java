package in.rido.jobservice.jobservice.enums;

public enum JobEvent {

    CREATE_JOB,
    INITIATE_JOB,
    START_JOB,
    JOB_STEP,
    COMPLETE_JOB, // job is complete, but not ended yet. Payment, review etc is pending.
    CANCEL_JOB,
    END_JOB // everything done for this job
}
