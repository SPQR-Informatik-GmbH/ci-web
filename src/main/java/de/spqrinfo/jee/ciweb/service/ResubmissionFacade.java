package de.spqrinfo.jee.ciweb.service;

import de.spqrinfo.jee.ciweb.persistence.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ResubmissionFacade {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getCustomers() {
        return this.entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }
}
