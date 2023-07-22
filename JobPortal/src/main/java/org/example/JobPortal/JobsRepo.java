package org.example.JobPortal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobsRepo extends CrudRepository<Jobs,Long> {

    List<Jobs>findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);

    List<Jobs>findByTitleContainingIgnoreCase(String Title);

    List<Jobs>findByDescriptionContainingIgnoreCase(String description);

    List<Jobs>findByJobType(Type jobType);

    @Query(value = "SELECT* FROM Jobs WHERE salary > :salary",nativeQuery = true)
    List<Jobs>findJobsWithSalaryAbove(Double salary);

    @Query(value = "SELECT * FROM Jobs WHERE company_name = :companyName",nativeQuery = true)
    List<Jobs>findJobsByCompanyName(String companyName);

    @Query(value = "SELECT* FROM Jobs WHERE employer_name = :employerName", nativeQuery = true)
    List<Jobs>findByEmployername(String employerName);

    @Query(value = "SELCET* FROM Jobs WHERE location = : location",nativeQuery = true)
    List<Jobs>findByLocations(String locations);
}
