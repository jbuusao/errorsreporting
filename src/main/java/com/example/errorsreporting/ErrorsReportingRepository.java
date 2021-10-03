package com.example.errorsreporting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ErrorsReportingRepository extends CrudRepository<Error, Long> {

    List<Error> findByConverter(String converter);
    Error findById(long id);
}
