package org.example.JobPortal;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobsController {

    JobsService jobsService;
@Autowired
    public JobsController(JobsService jobsService) {

        this.jobsService = jobsService;
    }

    @PostMapping("job")
    public String createJob(@Valid @RequestBody Jobs job){
    return jobsService.createJob(job);
    }

    @GetMapping("job/{Id}")
    public String getJobById(@PathVariable Long Id){
    return jobsService.getJobById(Id);
    }

    @PutMapping("job/{id}")
    public String updateJob(@PathVariable Long id, @RequestBody Jobs job){
    return jobsService.updateJob(id, job);
    }

    @DeleteMapping("job/{id}")
    public String deleteJob(@PathVariable Long id){
    return jobsService.deleteJob(id);
    }

    @GetMapping("job/search")
    public String searchJobs(@RequestParam(required = false) String title, @RequestParam(required = false) String description){
    if(title!=null && description != null){
        return jobsService.searchJobsByTitleAndDescription(title, description);
    }else if(title!=null){
        return jobsService.findByTitleContainingIgnoreCase(title);
    }else if(description!= null){
        return jobsService.findByDescriptionContainingIgnoreCase(description);
    }else{
        return "invalid criteria";
    }
    }

    @GetMapping("job/salary")
    public String searchJobsbysalary(@RequestParam Double salary){
    return jobsService.findJobsWithSalaryAbove(salary);
    }

    @GetMapping("job/jobtype/{jobtype}")
    public String findByJobType(@PathVariable Type jobtype){
    return jobsService.findByJobType(jobtype);
    }

    @GetMapping("job/cname")
    public String findJobByCompanyName(@RequestParam String companyName){
    return jobsService.findJobsByCompanyName(companyName);
    }


    @GetMapping("job/eName/{employername}")
    public String findByEmployerName(@PathVariable String employername){
    return jobsService.findByEmployername(employername);
    }

    @GetMapping("job/location/{location}")
    public String findByLocations(@PathVariable String location){
    return jobsService.findByLocations(location);
    }
}
