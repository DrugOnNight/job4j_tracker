package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void jobAscByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(
                new Job("Debug", 1),
                new Job("Compile", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void jobAscByPriority() {
        Comparator<Job> comparator = new JobAscByPriority();
        int rsl = comparator.compare(
                new Job("Debug", 1),
                new Job("Compile", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void jobDescByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("Debug", 1),
                new Job("Compile", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void jobDescByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("Debug", 1),
                new Job("Compile", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorDescByNameAndPrority() {
        Comparator<Job> descCmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = descCmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorAscByProrityAndName() {
        Comparator<Job> ascCmpPriorityName = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = ascCmpPriorityName.compare(
                new Job("Compile", 1),
                new Job("Debug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}