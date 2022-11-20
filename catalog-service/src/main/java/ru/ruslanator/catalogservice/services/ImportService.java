package ru.ruslanator.catalogservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
public class ImportService {

    private JobLauncher jobLauncher;
    private Job job;

    public void start() throws Exception{
        try {
            JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
            BatchStatus status;
            do {
                status = jobExecution.getStatus();
                log.debug("status = " + status);
            } while (status != BatchStatus.COMPLETED);
        } catch (JobExecutionAlreadyRunningException e) {
            log.error(e);
        }
    }
}
