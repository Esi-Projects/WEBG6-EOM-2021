package esi.webg6.g54895.model;

import esi.webg6.g54895.util.BeanValidationUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.PositiveOrZero;

@SpringBootTest
class TrackTest {

    @Autowired
    private BeanValidationUtil<Track> validator;

    @Test
    public void streamValid() {
        Artist artist = new Artist("artist", "Valid Artist");
        Track track = new Track(1, "Valid Track", 123456789, artist);
        validator.assertIsValid(track);
    }

    @Test
    public void streamNonPositiveError() {
        Artist artist = new Artist("artist", "Valid Artist");
        Track track = new Track(1, "Valid Track", -6, artist);
        validator.assertHasError(track, "stream", PositiveOrZero.class);
    }
}