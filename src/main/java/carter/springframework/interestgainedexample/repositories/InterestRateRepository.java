package carter.springframework.interestgainedexample.repositories;

import carter.springframework.interestgainedexample.models.InterestRate;
import org.springframework.data.repository.CrudRepository;

public interface InterestRateRepository extends CrudRepository<InterestRate, Long> {
}
