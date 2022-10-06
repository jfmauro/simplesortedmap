package com.example.simplesortedmap.comp;

import com.example.simplesortedmap.entity.Person;

import java.util.Comparator;
import java.util.Map;

public class PersonByAgeComparator implements Comparator<Map.Entry<Long, Person>> {

    @Override
    public int compare(Map.Entry<Long, Person> e1, Map.Entry<Long, Person> e2) {
        return e1.getValue().getAge() - e2.getValue().getAge();
    }
}
