package services;

import org.hibernate.SessionFactory;

import entities.Breed;

class BreedsService {

    private SessionFactory factory;

    public BreedsService(SessionFactory factory) {
        this.factory = factory;
    }

    public void saveBreed(Breed breed) {

    }

}
