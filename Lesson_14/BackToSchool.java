package Lesson_14;


/**
 * Write a description of class BackToSchool here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BackToSchool {
    public static void main(String[] args) {
        Person bob = new Person("Coach Bob", 27, "M");
        System.out.println(bob);
        
        Student lynne = new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
        System.out.println(lynne);
        
        Teacher mrJava = new Teacher("Duke Java", 34, "M", "Computer Science", 50000);
        System.out.println(mrJava);
        
        CollegeStudent ima = new CollegeStudent("Ima Frosh", 18, "F", "UCB123", 4.0, "English", 1);
        System.out.println(ima);
    }
}
