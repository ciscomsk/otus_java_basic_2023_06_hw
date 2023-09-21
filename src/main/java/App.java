public class App {
    public static void main(String[] args) {
        Animal animal = new Animal("some_animal", 100, 1, AnimalState.ACTIVE);
        int t1 = animal.run(90);
        System.out.println(t1);
        int t2 = animal.run(20);
        System.out.println(t2);
        animal.info();
        System.out.println();

        Dog dog = new Dog("some_dog", 100, 1, 2, AnimalState.ACTIVE);
        int t3 = dog.run(10);
        System.out.println(t3);
        int t4 = dog.swim(20);
        System.out.println(t4);
        dog.info();
        int t5 = dog.swim(50);
        System.out.println(t5);
        animal.info();
    }
}
