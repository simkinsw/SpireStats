package io.github.simkinsw.spirestats;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

@Repository
public interface CardChoiceRepository extends CrudRepository<CardChoiceData, Long> {

    List<CardChoiceData> findByRunData(RunData runData);

    List<CardChoiceData> findByCardNameAndPicked(String cardName, boolean picked);
}
