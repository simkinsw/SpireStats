package io.github.simkinsw.spirestats;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

@Repository
public interface CampfireDataRepository extends CrudRepository<CampfireData, Long> {

    List<CampfireData> findByRunData(RunData runData);
}
