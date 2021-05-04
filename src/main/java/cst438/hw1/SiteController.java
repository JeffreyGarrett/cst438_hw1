package cst438.hw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class SiteController {

    @Autowired
    MovieRatingRepository movieRatingRepository;

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/movies/new")
    public String getForm(Model model) {
        MovieRating movie = new MovieRating();
        model.addAttribute("movie", movie);
        return "movie_form";
    }

    @PostMapping("/movies/new")
    public String processNewRating(@Valid MovieRating movie, BindingResult result, Model model){
        if (result.hasErrors()){
            return "movie_form";
        }
        movie.setPostingDate(LocalDateTime.now());
        movieRatingRepository.save(movie);
        Iterable<MovieRating> movies = movieRatingRepository.findAllOrderByTitleAndPostingDate();
        model.addAttribute("movies", movies);
        return "movie_list";
    }

    @GetMapping("/movies")
    public String getAllMovies(Model model) {
        Iterable<MovieRating> movies = movieRatingRepository.findAllOrderByTitleAndPostingDate();
        model.addAttribute("movies", movies);
        return "movie_list";
    }

}
