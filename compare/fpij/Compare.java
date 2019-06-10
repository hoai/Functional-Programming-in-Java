/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package fpij;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

public class Compare {
  public static void printPeople(
    final String message, final List<Person> people) {
      
    System.out.println(message);
    people.forEach(System.out::println);
  }
  
  public static void main(String[] args) {
    final List<Person> people = Arrays.asList(
      new Person("John", 20, "male"),
      new Person("Sara", 21, "shemale"),
      new Person("Jane", 21, "shemale"),
      new Person("Greg", 35, "male"));
    
    {
    	System.out.println("//" + "START:Hoai AGE_ASCEND_OUTPUT");
    	Comparator<Person> compareAsc = (p1,p2) -> p1.hoaiAgeDiff(p2);
    	Comparator<Person> compareDesc = (p1,p2) -> p2.hoaiAgeDiff(p1);
    	Comparator<Person> compareName = (p1, p2) -> p1.getName().compareTo(p2.getName());
    	Comparator<Person> compareGender = (p1, p2) -> p1.getGender().compareTo(p2.getGender());
    	List<Person> hoaiAscAge = people.stream().sorted(compareGender).collect(toList());
    	hoaiAscAge.forEach(System.out::println);
    	
    	people.stream().max(compareAsc).ifPresent(y->System.out.println("eldest" + y));
    	final Function<Person, String> byName = person -> person.getName();
    	final Function<Person, String> byGender = person -> person.getGender();
    	List<Person> hoaiAscGenderAndAscAge = people.stream().sorted(comparing(byGender).thenComparing(byName)).collect(toList());
    	hoaiAscGenderAndAscAge.forEach(System.out::println);
    	
    }

{  
    System.out.println("//" + "START:AGE_ASCEND_OUTPUT");
    List<Person> ascendingAge = 
      people.stream()
            .sorted((person1, person2) -> person1.ageDifference(person2))
            .collect(toList());
    printPeople("Sorted in ascending order by age: ", ascendingAge);
    System.out.println("//" + "END:AGE_ASCEND_OUTPUT");
}

{  
    System.out.println("//" + "START:AGE_ASCEND_MR_OUTPUT");
    List<Person> ascendingAge = 
      people.stream()
            .sorted(Person::ageDifference)
            .collect(toList());

    printPeople("Sorted in ascending order by age: ", ascendingAge);
    System.out.println("//" + "END:AGE_ASCEND_MR_OUTPUT");
}

{
    System.out.println("//" + "START:AGE_DESCEND_OUTPUT");
    printPeople("Sorted in descending order by age: ",
      people.stream()
            .sorted((person1, person2) -> person2.ageDifference(person1))
            .collect(toList()));
    System.out.println("//" + "END:AGE_DESCEND_OUTPUT");

    System.out.println("//" + "START:REVERSE_ORDER_OUTPUT");
    Comparator<Person> compareAscending = 
      (person1, person2) -> person1.ageDifference(person2);
    Comparator<Person> compareDescending = compareAscending.reversed();

    printPeople("Sorted in ascending order by age: ",
      people.stream()
            .sorted(compareAscending)
            .collect(toList())
    );
    printPeople("Sorted in descending order by age: ",
      people.stream()
            .sorted(compareDescending)
            .collect(toList())
    );
    System.out.println("//" + "END:REVERSE_ORDER_OUTPUT");

    System.out.println("//" + "START:NAME_ASCEND_OUTPUT");
    printPeople("Sorted in ascending order by name: ",
      people.stream()
            .sorted((person1, person2) -> 
               person1.getName().compareTo(person2.getName()))
            .collect(toList()));
    System.out.println("//" + "END:NAME_ASCEND_OUTPUT");
}

{
    System.out.println("//" + "START:YOUNGEST_OUTPUT");
    people.stream()
          .min(Person::ageDifference)
          .ifPresent(youngest -> System.out.println("Youngest: " + youngest));
System.out.println("//" + "END:YOUNGEST_OUTPUT");
}

{
    System.out.println("//" + "START:ELDEST_OUTPUT");
    people.stream()
          .max(Person::ageDifference)
          .ifPresent(eldest -> System.out.println("Eldest: " + eldest));
    System.out.println("//" + "END:ELDEST_OUTPUT");
}

{
    people.stream()
          .sorted((person1, person2) -> 
             person1.getName().compareTo(person2.getName()));

    printPeople("Sorted in ascending order by name: ",
      people.stream()
            .sorted(comparing((Person person) -> person.getName()))
            .collect(toList()));

    final Function<Person, String> byName = person -> person.getName();
    people.stream()
          .sorted(comparing(byName));
}

{
    System.out.println("//" + "START:SORT_NAME_AND_AGE_OUTPUT");
    
    final Function<Person, Integer> byAge = person -> person.getAge();
    final Function<Person, String> byTheirName = person -> person.getName();
    
    printPeople("Sorted in ascending order by age and name: ",
      people.stream()
            .sorted(comparing(byAge).thenComparing(byTheirName))
            .collect(toList()));
    System.out.println("//" + "END:SORT_NAME_AND_AGE_OUTPUT");
}
  }
}
