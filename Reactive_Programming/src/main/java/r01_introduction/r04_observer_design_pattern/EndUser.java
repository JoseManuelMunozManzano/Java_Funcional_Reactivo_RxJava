package r01_introduction.r04_observer_design_pattern;

public class EndUser implements Observer{

    String name;

    public EndUser(String name, SubjectLibrary subject) {
        this.name = name;
        subject.subscribeObserver(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String avail) {
        System.out.println("Hello " + name + "! We are glad to notify you that your book is now " + avail);
    }
}
