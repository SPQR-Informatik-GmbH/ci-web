package de.spqrinfo.jee.ciweb.persistence;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @NotNull
    private String companyName;

    @OneToMany(mappedBy = "customer")
    private final List<Resubmission> resubmissions = new ArrayList<>();

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public List<Resubmission> getResubmissions() {
        return this.resubmissions;
    }
}
