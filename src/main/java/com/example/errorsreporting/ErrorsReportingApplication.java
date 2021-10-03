package com.example.errorsreporting;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 *
 select distinct converter from errors;
 select source, context, message, min(date) as begin, max(date) as end, count (*) as count  from errors where converter='TMFIN' group by converter, context, source, message order by min(date);
 select source, context, message, min(date) as begin, max(date) as end, count (*) as count  from errors where converter='TMFOUT' group by converter, context, source, message order by min(date);
 select converter, source, context, message, date from errors where converter='TMFOUT';
 */
@SpringBootApplication
public class ErrorsReportingApplication {

	private static final Logger log = LoggerFactory.getLogger(ErrorsReportingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ErrorsReportingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ErrorsReportingRepository repository) {
		return (args) -> {
			repository.save(new Error("TMFOUT", "foo.csv", "TR-001", "Unable to access OMB"));
			Thread.sleep(100);
			repository.save(new Error("TMFIN", "foo.csv", "TR-007", "Unable to access OMB"));
			Thread.sleep(100);
			repository.save(new Error("TMFOUT", "foo.csv", "TR-001", "Unable to access OMB"));
			Thread.sleep(100);
			repository.save(new Error("TMFOUT", "foo.csv", "TR-001", "Unable to access OMB"));
			Thread.sleep(100);
			repository.save(new Error("TMFOUT", "foo.csv", "TR-003", "Invalid ISIN"));
			Thread.sleep(100);
			repository.save(new Error("TMFOUT", "foo.csv", "TR-002", "Unable to access OMB"));
			Thread.sleep(100);
			repository.save(new Error("TMFOUT", "foo.csv", "TR-002", "Unable to access OMB"));
			Thread.sleep(100);
			repository.save(new Error("TMFIN", "foo.csv", "TR-007", "Unable to access ODS"));
			Thread.sleep(100);
			repository.save(new Error("TMFOUT", "foo.csv", "TR-001", "Unable to access ODS"));
		};
	}
}
