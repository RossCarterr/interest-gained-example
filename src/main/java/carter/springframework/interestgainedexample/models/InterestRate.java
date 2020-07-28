package carter.springframework.interestgainedexample.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InterestRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double interestAmount;

    public InterestRate() {
    }

    public InterestRate(Long id, int interestAmount) {
        this.id = id;
        this.interestAmount = interestAmount;
    }

    @Override
    public String toString() {
        return "InterestRate{" +
                "id=" + id +
                ", interestAmount=" + interestAmount +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = interestAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterestRate that = (InterestRate) o;

        if (interestAmount != that.interestAmount) return false;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
