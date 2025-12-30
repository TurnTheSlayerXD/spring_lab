package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.entities.CatToCat;
import com.example.entities.Cat;

@Repository
public interface CatToCatRepository extends JpaRepository<CatToCat, Long> {


    public boolean doesFriendShipExist(Long catId, Long friendId){
    }

    public List<Cat> findFriendsOfCat(Long catId){
    }
}