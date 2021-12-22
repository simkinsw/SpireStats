package io.github.simkinsw.spirestats;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RunRepo extends CrudRepository<RunData, Long> {

    RunData findByPlayId(String playId);

    List<RunData> findByCharacterChosen(String characterChosen);
}
