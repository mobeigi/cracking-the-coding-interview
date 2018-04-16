package chapter3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Animal Shelter
 *
 * @implSpec An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select
 * whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select
 * which specific animal they would like. Create the data structures to maintain this system and implement operations
 * such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in Linked List data structure.
 *
 * @implNote We used the built in Linked List data structure to store a list of Animals. We created two inner classes
 * for cat and dog and made animals identifiable by a name (for the purposes of this exercise). enqueue is implemented
 * by simply adding the animal to our linked list. dequeueAny simply pops the element at the front of the linked list
 * (which is the oldest animal regardless of type). For dequeueDog and dequeueCat we use an iterator and instanceof
 * to find the first animal of the given type before removing it from our linked list and returning it.
 *
 * [EXTERNAL] Could also maintain separate queues for each animal and store a timestamp to determine which animal is
 * the oldest. Each queue would be sorted amongst itself which means we pop to implement dequeueDog/dequeueCat. For
 * dequeueAny we would simply compare the timestamps for the Animal at the head of each queue.
 *
 * This would be more efficient than this implementation as more animals are added and in scenarios where one animal
 * is sparse (i.e. with 1 million dogs but only 10 cats, dequeueCat would be very slow).
 *
 */
public class Question6 {

    private LinkedList<Animal> animals;

    public Question6() {
        animals = new LinkedList<>();
    }

    /**
     * Add animal to queue
     * @param animal Animal to add to queue
     */
    public void enqueue(Animal animal) {
        animals.add(animal);
    }

    /**
     * Dequeue animal from queue
     *
     * @return Animal that was removed from queue
     * @throws NoSuchElementException if no animals in queue
     */
    public Animal dequeueAny() throws NoSuchElementException {
        if (animals.size() <= 0)
            throw new NoSuchElementException();

        return animals.pop();
    }

    /**
     * Dequeue dog from queue
     *
     * @return Dog that was removed from queue
     * @throws NoSuchElementException if no dogs in queue
     */
    public Dog dequeueDog() throws NoSuchElementException {
        for (Iterator<Animal> it = animals.iterator(); it.hasNext(); ) {
            Animal animal = it.next();
            if (animal instanceof Dog) {
                it.remove();
                return (Dog) animal;
            }
        }

        throw new NoSuchElementException();
    }

    /**
     * Dequeue cat from queue
     *
     * @return Cat that was removed from queue
     * @throws NoSuchElementException if no cats in queue
     */
    public Cat dequeueCat() throws NoSuchElementException {
        for (Iterator<Animal> it = animals.iterator(); it.hasNext(); ) {
            Animal animal = it.next();
            if (animal instanceof Cat) {
                it.remove();
                return (Cat)animal;
            }
        }

        throw new NoSuchElementException();
    }

    /**
     * Animal Class
     */
    public static class Animal {
        protected String name;

        public Animal() {}

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Animal animal = (Animal) o;

            return name != null ? name.equals(animal.name) : animal.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

    /**
     * Cat Class
     */
    public static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * Dog Class
     */
    public static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
