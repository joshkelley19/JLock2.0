package kelley.josh.repositories;

import kelley.josh.domain.JLockEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by joshuakelley on 11/1/16.
 */
public interface JLockEntryRepository extends JpaRepository<JLockEntry, Long> {
    List<JLockEntry> findById(Long id);
}
