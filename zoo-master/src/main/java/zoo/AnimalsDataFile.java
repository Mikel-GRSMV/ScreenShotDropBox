package zoo;

import lombok.Getter;

import java.util.List;

/**
 * Class for JSON deserialization.
 * JSON contains information about animals of each type
 */
@Getter
public class AnimalsDataFile {

    /**
     *  List containing info about carnivore type animals
     */
    private List<Carnivore> carnivoreAnimals;
    /**
     * List containing info about herbivore type animals
     */
    private List<Herbivore> herbivoreAnimals;
}

