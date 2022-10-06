package com.example.simplesortedmap;

import com.example.simplesortedmap.comp.PersonByAgeComparator;
import com.example.simplesortedmap.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class SimpleSortedMapApplication {

    public static void main(String[] args) {
        Person p1 = new Person(1L, 41, "john.doe");
        Person p2 = new Person(2L, 21, "rob.moe");
        Person p3 = new Person(3L, 26, "alan.zoe");

        Map<Long, Person> map = new HashMap<>();
        map.put(p1.getId(), p1);
        map.put(p2.getId(), p2);
        map.put(p3.getId(), p3);


        Set<Map.Entry<Long, Person>> entries = map.entrySet();

        List<Map.Entry<Long, Person>> persons = new ArrayList<>(entries);
        Collections.sort(persons, new PersonByAgeComparator());
        for (Map.Entry<Long, Person> entry : persons) {
            Person value = entry.getValue();
            System.out.println(value.getName() + " " + value.getAge());
        }


    }


}
