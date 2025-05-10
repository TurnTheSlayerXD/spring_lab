package services;

import entities.Breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BreedsRepository;




@Service
class BreedsService {

    private BreedsRepository repo;

    public BreedsService(@Autowired BreedsRepository repo) {
        this.repo = repo;
    }

    public void saveBreed(Breed breed) {

    }

}
