package Animal;

import Comparator.Comparable;

public class Animal implements Comparable {
  private String name;
  private int age;

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }



  public int compareTo(Object other){
    Animal otherAnimal = (Animal)other;
    if(this.getAge() < otherAnimal.getAge())
      return -1;
    else if (this.getAge() == otherAnimal.getAge())
      return 0;
    else
      return 1;
  }
}
