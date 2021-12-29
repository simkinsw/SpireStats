package io.github.simkinsw.spirestats;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

@Repository
public interface CardInfoRepository extends CrudRepository<CardInfo, Long> {
    List<CardInfo> findByCharacter(String character);
}
