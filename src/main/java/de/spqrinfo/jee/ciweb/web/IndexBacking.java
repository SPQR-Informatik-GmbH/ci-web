package de.spqrinfo.jee.ciweb.web;

import de.spqrinfo.jee.ciweb.persistence.Customer;
import de.spqrinfo.jee.ciweb.service.ResubmissionFacade;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class IndexBacking {

    @Inject
    private ResubmissionFacade resubmissionFacade;

    public String getPageTitle() {
        return "Resubmissions by customer";
    }

    public List<Customer> getCustomerList() {
        return this.resubmissionFacade.getCustomers();
    }
}
