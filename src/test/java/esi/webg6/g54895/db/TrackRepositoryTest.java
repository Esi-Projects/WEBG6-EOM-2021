package esi.webg6.g54895.db;

import esi.webg6.g54895.model.Track;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void updateTrackStream() {
        long trackId = 1;
        long streamToAdd = 1000;

        Track found = trackRepository.findById(trackId).orElse(null);
        long oldStream = found.getStream();

        trackRepository.updateTrackStream(trackId, streamToAdd);
        testEntityManager.flush();
        testEntityManager.clear();

        found = trackRepository.findById(trackId).orElse(null);
        long newStream = found.getStream();
        long resultStream = newStream - oldStream;
        assertEquals(streamToAdd, resultStream);
    }

    @Test
    void findByStreamGreaterThanEqual() {
        long minStreamToFind = 1920371005;
        List<Track> found = trackRepository.findByStreamGreaterThanEqual(minStreamToFind);
        assertEquals(1, found.size());
    }
}