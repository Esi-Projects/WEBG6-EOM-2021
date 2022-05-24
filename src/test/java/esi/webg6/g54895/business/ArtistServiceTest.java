package esi.webg6.g54895.business;

import esi.webg6.g54895.db.ArtistRepository;
import esi.webg6.g54895.model.Artist;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ArtistServiceTest {

    @Autowired
    private ArtistService artistService;

    @MockBean
    private ArtistRepository artistRepository;

    @Test
    void getArtists() {
        Artist artist1 = new Artist("mocka", "Mocka");
        Artist artist2 = new Artist("mocko", "Mocko");
        List<Artist> mockArtists = Arrays.asList(artist1, artist2);
        Mockito.when(artistRepository.findAll()).thenReturn(mockArtists);
        List<Artist> result = artistService.getArtists();
        assertTrue(result.containsAll(mockArtists));
    }

    @Test
    void getArtistByLogin() {
        String login = "mocka";
        Artist artist1 = new Artist(login, "Mocka");
        Mockito.when(artistRepository.findById(login)).thenReturn(Optional.of(artist1));
        Artist result = artistService.getArtistByLogin(login);
        assertEquals(artist1, result);
    }
}