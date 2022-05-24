package esi.webg6.g54895.db;

import esi.webg6.g54895.model.Track;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Track t SET t.stream = t.stream + :stream WHERE t.id = :id")
    void updateTrackStream(long id, long stream);

    @Query("select t from Track t where t.stream >= :stream")
    List<Track> findByStreamGreaterThanEqual(long stream);

}
