/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package fpij;

public class Person {
  private final String name;
  private final int age;
  private final String gender;
  
  public Person(final String theName, final int theAge, final String theGender) {
    name = theName;
    age = theAge;
    gender = theGender;
  } 
  
  public String getName() { return name; }
  public int getAge() { return age; }
  public String getGender() {
	  return gender;
  }
  
  public int ageDifference(final Person other) {
    return age - other.age;
  }
  public int hoaiAgeDiff(final Person other) {
	  return age - other.age;
  }
  
  public String toString() {
	  return String.format("%s - %d - %s", name, age, gender);
  }
}
