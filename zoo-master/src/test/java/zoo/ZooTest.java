package zoo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ZooTest {

    private static Zoo zoo;

    private AnimalType carnivore = AnimalType.CARNIVORE;
    private AnimalType herbivore = AnimalType.HERBIVORE;

    @BeforeAll
    static void setup() {
        zoo = new Zoo();
        String filePath = ZooTest.class.getClassLoader().getResource("zooAnimals.json").getPath();
        zoo.addAnimals(filePath);
    }

    @Test
    void addAnimals() {
        List<AnimalSpecies> testAnimals = new LinkedList<>();

        Carnivore panther = new Carnivore();
        panther.setName("Panther");
        panther.setAmount(1);

        Carnivore wolf = new Carnivore();
        wolf.setName("Wolf");
        wolf.setAmount(2);

        Herbivore cow = new Herbivore();
        cow.setName("Cow");
        cow.setAmount(3);

        Herbivore koala = new Herbivore();
        koala.setName("Koala");
        koala.setAmount(4);

        testAnimals.add(panther);
        testAnimals.add(wolf);
        testAnimals.add(cow);
        testAnimals.add(koala);

        Zoo testZoo = new Zoo();
        String filePath = ZooTest.class.getClassLoader().getResource("zooAnimalsTest.json").getPath();
        testZoo.addAnimals(filePath);

        Assertions.assertEquals(testAnimals,testZoo.getZooAnimalSpecies());
    }

    @Test
    void performActionForType() {

        zoo.performAction(Events.KEEPER_VISIT, carnivore);
        assertEquals(AnimalState.MAKE_NOISE, Zoo.getAllCarnivoreState());

        zoo.performAction(Events.KEEPER_VISIT, herbivore);
        assertEquals(AnimalState.MAKE_NOISE, zoo.getAllHerbivoreState());
        assertEquals(AnimalState.MAKE_NOISE, zoo.getAllCarnivoreState());

        zoo.performAction(Events.FEEDING, carnivore);
        assertEquals(AnimalState.CALM, zoo.getAllCarnivoreState());

        zoo.performAction(Events.FEEDING, herbivore);
        assertEquals(AnimalState.CALM, zoo.getAllHerbivoreState());
    }

    @Test
    void performAction() {

        if(zoo.getAllCarnivoreState().equals(AnimalState.SLEEP) &&
                zoo.getAllHerbivoreState().equals(AnimalState.SLEEP)) {

            zoo.performAction(Events.NIGHT);
            assertEquals(AnimalState.SLEEP, zoo.getAllCarnivoreState());
            assertEquals(AnimalState.SLEEP, zoo.getAllHerbivoreState());

            zoo.performAction(Events.MORNING);
            assertEquals(AnimalState.CALM, zoo.getAllCarnivoreState());
            assertEquals(AnimalState.CALM, zoo.getAllHerbivoreState());

            zoo.performAction(Events.THUNDER);
            assertEquals(AnimalState.MAKE_NOISE, zoo.getAllCarnivoreState());
            assertEquals(AnimalState.MAKE_NOISE, zoo.getAllHerbivoreState());
        }

        if(zoo.getAllCarnivoreState().equals(AnimalState.MAKE_NOISE) ||
                zoo.getAllHerbivoreState().equals(AnimalState.MAKE_NOISE)) {

            zoo.performAction(Events.NIGHT);
            assertNotEquals(AnimalState.SLEEP, zoo.getAllCarnivoreState());
            assertNotEquals(AnimalState.SLEEP, zoo.getAllHerbivoreState());

//            zoo.performAction(Events.MORNING);
//            assertEquals(AnimalState.CALM, zoo.getAllCarnivoreState());
//            assertEquals(AnimalState.CALM, zoo.getAllHerbivoreState());

            zoo.performAction(Events.THUNDER);
            assertEquals(AnimalState.MAKE_NOISE, zoo.getAllCarnivoreState());
            assertEquals(AnimalState.MAKE_NOISE, zoo.getAllHerbivoreState());
        }
    }
}