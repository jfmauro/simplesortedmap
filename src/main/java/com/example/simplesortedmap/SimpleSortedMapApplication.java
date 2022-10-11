package com.example.simplesortedmap;

import com.example.simplesortedmap.comp.PersonByAgeComparator;
import com.example.simplesortedmap.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        List<Long> keys = new ArrayList<>(map.keySet());

        Collections.sort(keys, new PersonByAgeComparator(map));

        List<Person> persons = new ArrayList<>();

        keys.stream()
            .sorted(new PersonByAgeComparator(map))
            .forEach(
                    l -> {
                        Person person = map.get(l);
                        persons.add(person);
                    }

                );

        ArrayList<Long> longs = keys.stream()
                .sorted(new PersonByAgeComparator(map))
                .collect(Collectors.toCollection(ArrayList::new));

        persons.stream()
                .forEach(p-> System.out.println(p.getName() + " " + p.getAge()));


    }


}
