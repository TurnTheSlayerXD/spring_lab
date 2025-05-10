package repositories;

import entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OwnersRepository extends JpaRepository<Owner, Integer> {

}
