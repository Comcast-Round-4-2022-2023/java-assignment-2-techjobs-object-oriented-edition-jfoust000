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

    @Test
    public void testJobsForEquality() {

        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job secondProductTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(productTester.equals(secondProductTester));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        char lineSeparator = '\n';

        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobToString = productTester.toString();

        assertEquals(jobToString.charAt(0), lineSeparator);
        assertEquals(jobToString.charAt(jobToString.length() - 1), lineSeparator);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        String lineSeparator = System.lineSeparator();

        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expectedJobToString =

                        lineSeparator
                        + "ID: " + productTester.getId() + lineSeparator
                        + "Name: " + productTester.getName() + lineSeparator
                        + "Employer: " + productTester.getEmployer() + lineSeparator
                        + "Location: " + productTester.getLocation() + lineSeparator
                        + "Position Type: " + productTester.getPositionType() + lineSeparator
                        + "Core Competency: " + productTester.getCoreCompetency()
                        + lineSeparator;



        String actualJobToString = productTester.toString();

        assertEquals(expectedJobToString, actualJobToString);

    }

    @Test
    public void testToStringHandlesEmptyField() {

        String lineSeparator = System.lineSeparator();
        String dataNotAvailable = "Data not available";

        Job productTester = new Job("Product tester", new Employer("ACME"), new Location(""),
                new PositionType("Quality control"), new CoreCompetency(""));

        String expectedJobToString =

                        lineSeparator
                        + "ID: " + productTester.getId() + lineSeparator
                        + "Name: " + productTester.getName() + lineSeparator
                        + "Employer: " + productTester.getEmployer() + lineSeparator
                        + "Location: " + dataNotAvailable + lineSeparator
                        + "Position Type: " + productTester.getPositionType() + lineSeparator
                        + "Core Competency: " + dataNotAvailable
                        + lineSeparator;

        String actualJobToString = productTester.toString();

        assertEquals(actualJobToString, expectedJobToString);


    }

    @Test
    public void testToStringJobObjectOnlyContainsDataForTheIdField() {

        String onlyIdFieldFound = "OOPS! This job does not seem to exist.";

        Job productTester = new Job();

        String actualJobToString = productTester.toString();

        assertEquals(actualJobToString, onlyIdFieldFound);

    }

}
