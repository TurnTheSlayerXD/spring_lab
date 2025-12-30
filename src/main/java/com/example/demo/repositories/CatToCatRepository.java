package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.example.entities.CatToCat;
import com.example.entities.Cat;

@Repository
public interface CatToCatRepository extends JpaRepository<CatToCat, Long> {


    @Query(value=" SELECT CASE WHEN (COUNT (*) > 0) THEN true ELSE false end" +
                  " FROM cat_to_cat as t " +
                  " WHERE t.cat_first_id = ?1 AND t.cat_second_id = ?2 " +
                      " OR t.cat_first_id = ?2 AND t.cat_second_id = ?1;", nativeQuery=true)
    public boolean doesFriendShipExist(Long catId, Long friendId);


    @Query(value=" SELECT * FROM cats as c " +
                    " WHERE c.id IN (SELECT r.cat_second_id FROM cat_to_cat as r WHERE r.cat_first_id = ?1)" +
                    " OR c.id IN (SELECT r.cat_first_id FROM cat_to_cat as r WHERE r.cat_second_id = ?1);", nativeQuery=true)
    public List<Cat> findFriendsOfCat(Long catId);


    @Query(value=" SELECT * FROM cat_to_cat as r where r.cat_first_id = ?1 AND r.cat_second_id = ?2" + 
                " OR r.cat_first_id = ?2 AND r.cat_second_id = ?1 ", nativeQuery=true)
    public List<CatToCat> getCatToCatRecords(Long catFirstId, Long catSecondId);
}

/*

case when (count(scen) > 0)  then true else false 

public interface UserRepository extends JpaRepository<User, Long> {
  @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
  User findByEmailAddress(String emailAddress);
}
*/