package s6.academy.proyecto.v3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;


public class ProjectV3JobExecutionListener implements JobExecutionListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectV3JobExecutionListener.class);

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JOB FINISHED! Time to verify the results");
        }
    }
}
