package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {

        this.id = nextId;
        nextId++;

    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {

        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;

    }

// TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }


    @Override
    public String toString() {

        char lineSeparator = '\n';
        String dataNotAvailable = "Data not available";
        String onlyIdFieldFound = "OOPS! This job does not seem to exist.";

        String jobToString = "";

        if ((this.getId() > 0) && this.getName() == null && this.getEmployer() == null && this.getLocation() == null
            && this.getPositionType() == null && this.getCoreCompetency() == null)  {

            jobToString = onlyIdFieldFound;

        } else {

            jobToString =

                            lineSeparator
                            + "ID: " + this.getId() + lineSeparator
                            + "Name: " + (Objects.equals(this.getName(), "") ? dataNotAvailable : this.getName()) + lineSeparator
                            + "Employer: " + (Objects.equals(this.getEmployer().getValue(), "") ? dataNotAvailable : this.getEmployer()) + lineSeparator
                            + "Location: " + (Objects.equals(this.getLocation().getValue(), "") ? dataNotAvailable : this.getLocation()) + lineSeparator
                            + "Position Type: " + (Objects.equals(this.getPositionType().getValue(), "") ? dataNotAvailable : this.getPositionType()) + lineSeparator
                            + "Core Competency: " + (Objects.equals(this.getCoreCompetency().getValue(), "") ? dataNotAvailable : this.getCoreCompetency())
                            + lineSeparator;

        }

        return jobToString;

    }

}
