package ru.ruslanator.catalogservice.services;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.stereotype.Service;

import javax.batch.operations.JobRestartException;

@Service
@Slf4j
@NoArgsConstructor
public class ImportService {

    private JobLauncher jobLauncher;
    private Job job;

    public ImportService(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    public void start() throws Exception{
        try {
            JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
            BatchStatus status;
            do {
                status = jobExecution.getStatus();
                log.info("status = " + status);
                Thread.sleep(1000);
            } while (status != BatchStatus.COMPLETED);
        } catch (JobExecutionAlreadyRunningException | JobRestartException
                | JobInstanceAlreadyCompleteException | JobParametersInvalidException
                | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
