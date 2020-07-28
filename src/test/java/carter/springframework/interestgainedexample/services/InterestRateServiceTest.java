package carter.springframework.interestgainedexample.services;

import carter.springframework.interestgainedexample.controllers.InterestRateController;
import carter.springframework.interestgainedexample.models.InterestRate;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class InterestRateServiceTest {

    @Autowired
    private InterestRateService interestRateService;

    @Test
    @Order(1)
    void saveAmountWithInterestTest6400() {
        int amount = 6400;
        InterestRate amountObject = interestRateService.saveAmountWithInterest(amount);
        assertEquals("InterestRate{id=1, interestAmount=132.0}", amountObject.toString());
    }

    @Test
    @Order(2)
    void saveAmountWithInterestBetween1000And5000() {
        int amount = 2500;
        InterestRate amountObject = interestRateService.saveAmountWithInterest(amount);
        assertEquals("InterestRate{id=2, interestAmount=40.0}", amountObject.toString());
    }

    @Test
    @Order(3)
    void saveAmountWithInterestBelow1000() {
        int amount = 999;
        InterestRate amountObject = interestRateService.saveAmountWithInterest(amount);
        assertEquals("InterestRate{id=3, interestAmount=9.99}", amountObject.toString());
    }

    @Test
    @Order(4)
    void getInterestRateAmountBelow1000() {
        int amount = 999;
        double amountDouble = interestRateService.getInterestRateAmount(amount);
        assertEquals(9.99, amountDouble);
    }

    @Test
    @Order(5)
    void getInterestRateAmountAbove5000() {
        int amount = 2500;
        double amountDouble = interestRateService.getInterestRateAmount(amount);
        assertEquals(40.0, amountDouble);
    }

    @Test
    @Order(6)
    void getInterestRateAmountBetween1000And5000() {
        int amount = 6400;
        double amountDouble = interestRateService.getInterestRateAmount(amount);
        assertEquals(132.0, amountDouble);
    }
}