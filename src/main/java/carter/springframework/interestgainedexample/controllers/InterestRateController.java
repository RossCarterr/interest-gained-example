package carter.springframework.interestgainedexample.controllers;

import carter.springframework.interestgainedexample.models.InterestRate;
import carter.springframework.interestgainedexample.repositories.InterestRateRepository;
import carter.springframework.interestgainedexample.services.InterestRateService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class InterestRateController {

    public final InterestRateService interestRateService;

    private final InterestRateRepository interestRateRepository;

    public InterestRateController(InterestRateRepository interestRateRepository, InterestRateService interestRateService) {
        this.interestRateRepository = interestRateRepository;
        this.interestRateService = interestRateService;
    }

    @ResponseBody
    @GetMapping("/interestAmount")
    public Object getInterestRates(Model model) {
        model.addAttribute("interestAmount",interestRateRepository.findAll());
        return model.getAttribute("interestAmount");
    }

    @ResponseBody
    @PostMapping("/interestRateCalculator/{amountRequested}")
    public InterestRate postAmounts(@PathVariable int amountRequested) {
            return interestRateService.saveAmountWithInterest(amountRequested);
    }

}
