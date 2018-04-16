package chapter3;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Question6Test {

    @Test
    void animalShelter() {
        Question6 question6 = new Question6();

        //Attempt to dequeue empty queue
        assertThrows(NoSuchElementException.class, question6::dequeueAny);
        assertThrows(NoSuchElementException.class, question6::dequeueDog);
        assertThrows(NoSuchElementException.class, question6::dequeueCat);

        //Enqueue animals
        question6.enqueue(new Question6.Dog("Dog 1"));
        question6.enqueue(new Question6.Dog("Dog 2"));
        question6.enqueue(new Question6.Cat("Cat 1"));
        question6.enqueue(new Question6.Dog("Dog 3"));
        question6.enqueue(new Question6.Cat("Cat 2"));
        question6.enqueue(new Question6.Cat("Cat 3"));
        question6.enqueue(new Question6.Dog("Dog 4"));
        question6.enqueue(new Question6.Dog("Dog 5"));
        question6.enqueue(new Question6.Cat("Cat 4"));
        question6.enqueue(new Question6.Dog("Dog 6"));
        question6.enqueue(new Question6.Cat("Cat 5"));
        question6.enqueue(new Question6.Cat("Cat 6"));

        //Dequeue ensuring we always return next animal based on insertion order
        assertEquals(new Question6.Dog("Dog 1"), question6.dequeueAny());
        assertEquals(new Question6.Dog("Dog 2"), question6.dequeueDog());
        assertEquals(new Question6.Dog("Dog 3"), question6.dequeueDog());
        assertEquals(new Question6.Cat("Cat 1"), question6.dequeueAny());
        assertEquals(new Question6.Dog("Dog 4"), question6.dequeueDog());
        assertEquals(new Question6.Cat("Cat 2"), question6.dequeueCat());
        assertEquals(new Question6.Cat("Cat 3"), question6.dequeueCat());
        assertEquals(new Question6.Cat("Cat 4"), question6.dequeueCat());
        assertEquals(new Question6.Cat("Cat 5"), question6.dequeueCat());
        assertEquals(new Question6.Dog("Dog 5"), question6.dequeueDog());
        assertEquals(new Question6.Dog("Dog 6"), question6.dequeueAny());
        assertEquals(new Question6.Cat("Cat 6"), question6.dequeueAny());

        //Attempt to dequeue empty queue
        assertThrows(NoSuchElementException.class, question6::dequeueAny);
        assertThrows(NoSuchElementException.class, question6::dequeueDog);
        assertThrows(NoSuchElementException.class, question6::dequeueCat);
    }
}