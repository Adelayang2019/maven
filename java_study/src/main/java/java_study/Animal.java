package java_study;

public class Animal {
    private String name;
    private int id;
    public final double PI=3.14;
    public Animal(String myName,int myid) {
        name = myName;
        id = myid;
    }
    public void eat() {
        System.out.println(name+"is eating");
    }
    public void sleep() {
        System.out.println(name+"is sleeping");

    }
    public void introduction() {
        System.out.println("i am"+id);
    }
}
