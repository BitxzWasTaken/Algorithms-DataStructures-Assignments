public class Main {
    public static void main(String[] args) {
        AnimalShelterQueue shelter = new AnimalShelterQueue();

        shelter.enqueue(new Dog("Rex"));
        shelter.enqueue(new Cat("Whiskers"));
        shelter.enqueue(new Dog("Buddy"));
        shelter.enqueue(new Cat("Mittens"));

        shelter.printQueue();

        shelter.dequeueAny();
        shelter.dequeueDog();
        shelter.dequeueCat();

        shelter.printQueue();
    }
}
