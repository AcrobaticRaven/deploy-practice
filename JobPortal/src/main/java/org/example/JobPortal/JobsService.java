package org.example.JobPortal;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsService {

    private final JobsRepo jobsRepo;

    public JobsService(JobsRepo jobsRepo) {
        this.jobsRepo = jobsRepo;
    }
    public String createJob(Jobs job){
        Jobs savedJobs = jobsRepo.save(job);
        return "Job created with ID : " + job.getId();
    }

    public String getJobById(Long Id){
        Optional<Jobs>JobOptional = jobsRepo.findById(Id);
        return JobOptional.map(job -> "job Found: " + job.toString()).orElse("Job not found");
    }

    public String updateJob(Long Id, Jobs job){
        Optional<Jobs>existenceJobsOptional = jobsRepo.findById(Id);
        if(existenceJobsOptional.isPresent()){
           Jobs existingJobs = existenceJobsOptional.get();
           existingJobs.setTitle(job.getTitle());
           existingJobs.setDescription(job.getDescription());
           existingJobs.setLocation(job.getLocation());
           existingJobs.setSalary(job.getSalary());
           existingJobs.setCompanyEmail(job.getCompanyEmail());
           existingJobs.setCompanyName(job.getCompanyName());
           existingJobs.setEmployerName(job.getEmployerName());
           existingJobs.setJobType(job.getJobType());
           return "Job has been updated";
        }return "Id not found";
    }

    public String deleteJob(Long Id){
        jobsRepo.deleteById(Id);
        return "Id has been deleted";
    }

    public String searchJobsByTitleAndDescription(String title, String description){
        List<Jobs>jobs = jobsRepo.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(title,description);
        return "search result : " + jobs.toString();
    }
    public String findByTitleContainingIgnoreCase(String title){
        List<Jobs>jobs = jobsRepo.findByTitleContainingIgnoreCase(title);
        return " search result : " + jobs.toString();
    }
    public String findByDescriptionContainingIgnoreCase(String description){
        List<Jobs>jobs = jobsRepo.findByDescriptionContainingIgnoreCase(description);
        return " search result  : " + jobs.toString();
    }

    public String findByJobType(Type jobtype){
        List<Jobs>jobs = jobsRepo.findByJobType(jobtype);
        return "search result : " + jobs.toString();
    }

    public String findJobsWithSalaryAbove(Double salary){
        List<Jobs>jobs = jobsRepo.findJobsWithSalaryAbove(salary);
        return "search result : " + jobs.toString();
    }

    public String findJobsByCompanyName(String companyName){
        List<Jobs>jobs = jobsRepo.findJobsByCompanyName(companyName);
        return "search result : " + jobs.toString();
    }

    public String findByEmployername(String employername){
        List<Jobs>jobs = jobsRepo.findByEmployername(employername);
        return "search result : " + jobs.toString();
     }
     public String findByLocations(String location){
        List<Jobs>jobs = jobsRepo.findByLocations(location);
        return "search result : " + jobs.toString();
     }
}
