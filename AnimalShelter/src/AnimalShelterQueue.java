import java.util.LinkedList;

public class AnimalShelterQueue {
    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    private int order;

    public AnimalShelterQueue() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        order = 0;
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
        System.out.println(animal.getName() + " the " + animal.getClass().getSimpleName() + " was added.");
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            System.out.println("No animals available.");
            return null;
        } else if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        if (dogs.isEmpty()) {
            System.out.println("No dogs available.");
            return null;
        }
        Dog dog = dogs.poll();
        System.out.println("Dequeued Dog: " + dog.getName());
        return dog;
    }

    public Cat dequeueCat() {
        if (cats.isEmpty()) {
            System.out.println("No cats available.");
            return null;
        }
        Cat cat = cats.poll();
        System.out.println("Dequeued Cat: " + cat.getName());
        return cat;
    }

    public void printQueue() {
        System.out.println("\nDogs in queue:");
        for (Dog d : dogs) System.out.println(d.getName());

        System.out.println("Cats in queue:");
        for (Cat c : cats) System.out.println(c.getName());
    }
}