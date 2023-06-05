package interface_practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnimalTest {

    @Test
    public void testDog(){
        Animal dog = new Dog();
        Assertions.assertEquals(dog.cry(), "bowwow");
        Assertions.assertEquals(dog.walk(), "animal is walking");
    }

    @Test
    public void testCat(){
        Animal cat = new Cat();
        Assertions.assertEquals(cat.cry(), "grrr");
        Assertions.assertEquals(cat.walk(), "soft walking");
    }
}