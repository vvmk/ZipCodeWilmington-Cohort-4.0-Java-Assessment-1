package com.zipcodewilmington.assessment1.part3;

import java.util.ArrayList;

/**
 * Created by leon on 2/16/18.
 */
public class PetOwner {
    private ArrayList<Pet> pets;
    private String name;

    /**
     * @param name name of the owner of the Pet
     * @param pets array of Pet object
     */
    public PetOwner(String name, Pet... pets) {

        this.name = (name != null) ? name : "";
        this.pets = new ArrayList<>();
        if (pets != null) {
            for (Pet p : pets)
                addPet(p);
        }

    }

    /**
     * @param pet pet to be added to the composite collection of Pets
     */
    public void addPet(Pet pet) {
        pet.setOwner(this);
        pets.add(pet);
    }

    /**
     * @param pet pet to be removed from the composite collection Pets
     */
    public boolean removePet(Pet pet) {
        return pets.remove(pet);
    }

    /**
     * @param pet pet to evaluate ownership of
     * @return true if I own this pet
     */
    public Boolean isOwnerOf(Pet pet) {
        return pets.contains(pet);
    }

    /**
     * @return the age of the Pet object whose age field is the lowest amongst all Pets in this class
     */
    public Integer getYoungestPetAge() {
        int lowestAge = Integer.MAX_VALUE;
        for (Pet p : pets) {
            if (p.getAge() < lowestAge)
                lowestAge = p.getAge();
        }
        return lowestAge;
    }


    /**
     * @return the age of the Pet object whose age field is the highest amongst all Pets in this class
     */
    public Integer getOldestPetAge() {
        int highestAge = 0;
        for (Pet p : pets) {
            if (p.getAge() > highestAge)
                highestAge = p.getAge();
        }
        return highestAge;
    }


    /**
     * @return the sum of ages of Pet objects stored in this class divided by the number of Pet object
     */
    public Float getAveragePetAge() {
        float age = 0.0f;
        for (Pet p : pets)
            age += p.getAge();
        return age / getNumberOfPets();
    }

    /**
     * @return the number of Pet objects stored in this class
     */
    public Integer getNumberOfPets() {
        return pets.size();
    }

    /**
     * @return the name property of the Pet
     */
    public String getName() {
        return name;
    }

    /**
     * @return array representation of animals owned by this PetOwner
     */
    public Pet[] getPets() {
        return pets.toArray(new Pet[0]);
    }
}
