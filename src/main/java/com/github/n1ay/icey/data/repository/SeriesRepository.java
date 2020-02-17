package com.github.n1ay.icey.data.repository;

import com.github.n1ay.icey.data.model.Series;
import org.springframework.data.repository.CrudRepository;

public interface SeriesRepository extends CrudRepository<Series, Long> {
    Series findById(long id);
    void deleteById(long id);
}
