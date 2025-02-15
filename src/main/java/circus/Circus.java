package circus;

import circus.animal.*;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = { // size of array is fixed
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        System.out.println(animals.length);
        makeAnimalsTalk();
        System.out.println("Total value of animals " + calculateAssetValue(animals));
        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
        animals[3] = new Elephant("Strong One");
        System.out.println(animals.length);

        ArrayList<Animal> animalList = new ArrayList<>(Arrays.asList(animals));

        animalList.add(new Parrot("Perry"));
        animalList.add(new Elephant("Groot"));
        Duck andy = new Duck("Andy");
        animalList.add(andy);

        // substitutability allows to add specific animals to "Animal" ArrayList

        System.out.println("Before sorting: ");
        printAllAnimals(animalList);
        System.out.println("size of the array list: " + animalList.size());

        System.out.println("Andy is in position: " + animalList.indexOf(andy));

        animalList.sort(Animal.animalNameComparator);
        System.out.println("After sorting");
        printAllAnimals(animalList);

        animalList.add(new Tiger("Sherkhan"));
        System.out.println("Number of animals: " + animalList.size());

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Louie");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Dolly");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}
