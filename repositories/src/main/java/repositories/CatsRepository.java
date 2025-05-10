
package repositories;

import entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CatsRepository extends JpaRepository<Cat, Integer> {
}
