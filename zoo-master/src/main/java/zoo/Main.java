package zoo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] argv) {

        Set<AnimalSpecies> animalSpeciesSet = new HashSet<>();
        animalSpeciesSet.add(new Carnivore());
        animalSpeciesSet.add(new Carnivore());
        animalSpeciesSet.add(new Carnivore());
        for (AnimalSpecies c: animalSpeciesSet) {
            System.out.println("HashCode Carnivore: " + c.hashCode());
        }

        String filePath = argv[0];

        // Create zoo
        Zoo zoo = new Zoo();
        // Add animals to the zoo
        zoo.addAnimals(filePath);

        // Create user action trigger
        ActionTrigger trigger = new ActionTrigger(zoo);

        AnimalType herbivore = AnimalType.HERBIVORE;
        AnimalType carnivore = AnimalType.CARNIVORE;

        // All of the following actions are up to users choice
        zoo.printAllStates();
        trigger.setMorning();
        zoo.printAllStates();

        trigger.visit(herbivore);
        zoo.printAllStates();
//        trigger.visit(carnivore);
        trigger.feedAnimals(herbivore);
        zoo.printAllStates();

        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();

        trigger.setThunder();
        zoo.printAllStates();
        trigger.feedAnimals(carnivore);
        zoo.printAllStates();

        trigger.feedAnimals(herbivore);
        zoo.printAllStates();
        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();
    }
}