package com.example.simplesortedmap.comp;

import com.example.simplesortedmap.entity.Person;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PersonByAgeComparator implements Comparator<Long> {

    private Map<Long, Person> persons = new HashMap<>();
    public PersonByAgeComparator(Map<Long, Person> persons){
        this.persons=persons;
    }

    @Override
    public int compare(Long e1, Long e2) {
        return persons.get(e1).getAge() - persons.get(e2).getAge();
    }
}
