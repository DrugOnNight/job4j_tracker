package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenAddEqualsKey() {
        Citizen citizen1 = new Citizen("12345abc", "Oleg Godizov");
        Citizen citizen2 = new Citizen("12345abc", "Aleksey Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        Assert.assertFalse(office.add(citizen2));
    }
}