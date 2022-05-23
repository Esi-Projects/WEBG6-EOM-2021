package esi.webg6.g54895.business;

import esi.webg6.g54895.db.ArtistRepository;
import esi.webg6.g54895.model.Artist;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {

    @Autowired
    private final ArtistRepository artistRepository;

    public List<Artist> getArtists() {
        return (List<Artist>) artistRepository.findAll();
    }

    public Artist getArtistByLogin(String login) {
        return artistRepository.findById(login).orElse(null);
    }
}
