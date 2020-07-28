package carter.springframework.interestgainedexample.services;

import carter.springframework.interestgainedexample.models.InterestRate;
import carter.springframework.interestgainedexample.repositories.InterestRateRepository;
import org.springframework.stereotype.Service;

@Service
public class InterestRateService {
    private final InterestRateRepository interestRateRepository;

    public InterestRateService(InterestRateRepository interestRateRepository) {
        this.interestRateRepository = interestRateRepository;
    }

    // Works out how much will be added to the amount given
    public double getInterestRateAmount(int amountBeforeInterest) {
        double amountAfterInterest;
        if (1000 <= amountBeforeInterest && amountBeforeInterest <= 5000) {
            amountAfterInterest = (1000*0.01) + ((amountBeforeInterest - 1000)*0.02);
            return amountAfterInterest;
        } else if (amountBeforeInterest > 5000) {
            amountAfterInterest = (1000*0.01) + (4000*0.02) + ((amountBeforeInterest -5000)*0.03);
            return amountAfterInterest;
        } else {
            amountAfterInterest = (amountBeforeInterest *0.01);
            return amountAfterInterest;
        }
    }

    // Saves the amount to h2 database
    public InterestRate saveAmountWithInterest(int amountWithInterest){
        InterestRate saveAmount = new InterestRate();
        saveAmount.setInterestAmount(getInterestRateAmount(amountWithInterest));
        return interestRateRepository.save(saveAmount);
    }
}
