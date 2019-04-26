package java_study;

public class Children extends Animal {
    public String str = "abc";

    public Children(String myName, int myid) {
        super(myName, myid);

    }
    public void eat() {
        System.out.println("children eating");
    }
    public void introduction() {
        super.introduction();
        System.out.println("hello ,i am " +str);
        eat();
        super.eat();
    }
    public static void main(String[] args) {
        Children c = new Children("Dog",1);
        System.out.println(c.PI);
        c.eat();
        c.introduction();
        c.sleep();
    }

}