package cst438.hw1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRatingRepository extends CrudRepository<MovieRating, Long> {
    @Query("select m from MovieRating m order by title, postingDate desc")

    List<MovieRating> findAllOrderByTitleAndPostingDate();

}
