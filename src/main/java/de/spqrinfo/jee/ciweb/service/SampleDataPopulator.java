package de.spqrinfo.jee.ciweb.service;

import de.spqrinfo.jee.ciweb.persistence.Customer;
import de.spqrinfo.jee.ciweb.persistence.Resubmission;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Singleton
@Startup
public class SampleDataPopulator {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    private void createSampleData() {
//        this.entityManager.getTransaction().begin();

        // Delete existing data
//        if (!this.entityManager.createQuery("SELECT r FROM Resubmission r", Resubmission.class).getResultList().isEmpty()) {
//            this.entityManager.createQuery("DELETE FROM Resubmission").executeUpdate();
//        }
//        if (!this.entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList().isEmpty()) {
//            this.entityManager.createQuery("DELETE FROM Customer").executeUpdate();
//        }

        // Create Customer A with some Resubmissions
        final Customer cA = new Customer();
        cA.setCompanyName("Customer A");
        this.entityManager.persist(cA);

        final Resubmission r1 = new Resubmission();
        r1.setActive(true);
        r1.setDue(new Date());
        r1.setNote("A note 1");
        r1.setCustomer(cA);
        cA.getResubmissions().add(r1);

        final Resubmission r2 = new Resubmission();
        r2.setActive(true);
        r2.setDue(new Date());
        r2.setNote("A note 2");
        r2.setCustomer(cA);
        cA.getResubmissions().add(r2);

        this.entityManager.persist(r1);
        this.entityManager.persist(r2);

        // Create Customer B with a Resubmission
        final Customer cB = new Customer();
        cB.setCompanyName("Customer B");
        this.entityManager.persist(cB);

        final Resubmission r3 = new Resubmission();
        r3.setActive(true);
        r3.setDue(new Date());
        r3.setNote("A note 3");
        r3.setCustomer(cB);
        cB.getResubmissions().add(r3);

        this.entityManager.persist(r3);

//        this.entityManager.getTransaction().commit();
    }
}
