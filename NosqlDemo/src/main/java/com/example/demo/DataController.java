package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5.
 */
@RestController
public class DataController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public  Person save(){
        Person p = new Person("zhaozhen",23);
        Collection<Location> locations = new LinkedHashSet<>();
        Location loc1 =new Location("上海","2012");
        Location loc2 =new Location("合肥","2013");
        Location loc3 =new Location("武汉","2014");
        Location loc4 =new Location("北京","2015");
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        p.setLocations(locations);
        return  personRepository.save(p);
    }

    @RequestMapping("/q1")
    public  Person q1(String name){
        return  personRepository.findByName(name);
    }

    @RequestMapping("q2")
    public List<Person> q2 (Integer age){
        return  personRepository.withQueryFindByAge(age);
    }
}
