package esi.webg6.g54895.web;

import esi.webg6.g54895.business.ArtistService;
import esi.webg6.g54895.model.Artist;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArtistController {

    @Autowired
    private final ArtistService artistService;

    @GetMapping("/artists")
    public String getArtists(Model model) {
        List<Artist> artists = artistService.getArtists();
        model.addAttribute("artists", artists);
        return "artist";
    }
}
