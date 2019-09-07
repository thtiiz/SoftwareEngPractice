package Animal;

import Comparator.Data;

public class AnimalApp {

  public static void main(String[] args) {
    Animal[] animals = new Animal[5];
    animals[0] = new Animal("opor", 2);
    animals[1] = new Animal("proud", 15);
    animals[2] = new Animal("aum", 6);
    animals[3] = new Animal("frong", 7);
    animals[4] = new Animal("ford", 8);
    Data.sort(animals);
    for (Animal a : animals) {
      System.out.println(a.getName() + " " +a.getAge());
    }
  }
}
