// T dibatasi hanya boleh tipe A atau turunannya (B dan C)
class Bound<T extends A> {

    private T objRef;

    public Bound(T obj) {
        this.objRef = obj;
    }

    public void doRunTest() {
        this.objRef.displayClass();
    }
}

// class A sebagai parent class (super class)
class A {

    public void displayClass() {
        System.out.println("Inside super class A");
    }
}

// class B adalah turunan dari A, method displayClass() di-override
class B extends A {

    public void displayClass() {
        System.out.println("Inside sub class B");
    }
}

// class C adalah turunan dari A, method displayClass() di-override
class C extends A {

    public void displayClass() {
        System.out.println("Inside sub class C");
    }
}

public class BoundedClass {

    public static void main(String a[]) {

        // Creating object of sub class C and
        // passing it to Bound as a type parameter.
        Bound<C> bec = new Bound<C>(new C());
        bec.doRunTest();

        // Creating object of sub class B and
        // passing it to Bound as a type parameter.
        Bound<B> beb = new Bound<B>(new B());
        beb.doRunTest();

        // similarly passing super class A
        Bound<A> bea = new Bound<A>(new A());
        bea.doRunTest();
    }
}

