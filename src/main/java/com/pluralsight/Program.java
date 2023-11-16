package com.pluralsight;

import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Emily", "Thompson", 28));
        people.add(new Person("Emily", "Rodriguez", 35));
        people.add(new Person("Lily", "Morgan", 22));
        people.add(new Person("Mason", "Patel", 40));
        people.add(new Person("Grace", "Mitchell", 31));
        people.add(new Person("Aiden", "Sullivan", 26));
        people.add(new Person("Sofia", "Turner", 29));
        people.add(new Person("Caleb", "Walker", 33));
        people.add(new Person("Ava", "Nguyen", 24));
        people.add(new Person("Noah", "Parker", 27));

        System.out.print("Search Function:\nPlease enter the 'first name' or 'last name' of the people you would like to display\nUser Input: ");
        String chosenName = input.nextLine();

        List<Person> chosenPeople = people.stream().filter(person -> person.getFirstName().equalsIgnoreCase(chosenName) || person.getLastName().equalsIgnoreCase(chosenName)).collect(Collectors.toList());

        long count = people.stream().count();

        long averageAge = ((people.stream().map(Person::getAge).reduce(0, Integer::sum)).longValue() / people.stream().count());

        Person youngestPerson = people.stream().min(Comparator.comparing(Person::getAge)).orElseThrow(NoSuchElementException::new);

        Person oldestPerson = people.stream().max(Comparator.comparing(Person::getAge)).orElseThrow(NoSuchElementException::new);

        System.out.println("\nList Of Matches: ");
        for(Person person: chosenPeople){
            System.out.print(person.toString());
        }

        System.out.println("\nNumber Of People: ");
        System.out.print(count);

        System.out.println("\nOldest Person: ");
        System.out.print(oldestPerson.toString());

        System.out.println("\nYoungest Person: ");
        System.out.print(youngestPerson.toString());

        System.out.println("\nAverage Age: ");
        System.out.print(averageAge);
    }
}
