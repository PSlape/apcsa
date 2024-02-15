package Lesson_29;


/*
 * Name: Peyton Slape
 * Lab: 29.1
 * Date: 2/15/24
 * Purpose: Practice using interfaces and abstract methods
 * Description: Contains all of the animals
 */
public class Farm {
    private Animal[] animals = new Animal[3];
    
    public Farm() {
        animals[0] = new NamedCow("cow", "joe", "moo");
        animals[1] = new Chick("chick", "cheep", "cluck");
        animals[2] = new Pig("pig", "oink");
    }
    
    public void animalSounds() {
        for(Animal a : animals) {
            System.out.println(a.getType() + " goes " + a.getSound());
        }
        System.out.println("The cow is known as " + ((NamedCow) animals[0]).getName());
    }
}
