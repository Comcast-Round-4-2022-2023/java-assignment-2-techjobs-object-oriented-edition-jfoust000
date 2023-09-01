package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Job;
import static org.junit.Assert.*;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {

        Job webDev = new Job();
        Job backEndDev = new Job();

        assertNotEquals(webDev.getId(),backEndDev.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {

       Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(productTester instanceof Job);
        assertTrue(productTester.getEmployer() instanceof Employer);
        assertTrue(productTester.getLocation() instanceof Location);
        assertTrue(productTester.getPositionType() instanceof PositionType);
        assertTrue(productTester.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(productTester.getName(), "Product tester");
        assertEquals(productTester.getEmployer().getValue(), "ACME");
        assertEquals(productTester.getLocation().getValue(), "Desert");
        assertEquals(productTester.getPositionType().getValue(), "Quality control");
        assertEquals(productTester.getCoreCompetency().getValue(), "Persistence");


    }

    public void testJobsForEquality() {

        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job secondProductTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(productTester.equals(secondProductTester));

    }

}
