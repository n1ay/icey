package com.github.n1ay.icey.controller;

import com.github.n1ay.icey.data.model.Series;
import com.github.n1ay.icey.data.repository.SeriesRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class SeriesController {

    final SeriesRepository seriesRepository;

    public SeriesController(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @GetMapping("/{id}")
    private Series getSeries(@PathVariable("id") long id) {
        return seriesRepository.findById(id);
    }

    @GetMapping("/")
    private Iterable<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    @DeleteMapping("/{id}")
    private void deleteSeries(@PathVariable("id") long id) {
        seriesRepository.deleteById(id);
    }

    @PostMapping("/")
    private Series createSeries(@RequestBody Series series) {
        series.setId(null);
        return seriesRepository.save(series);
    }

    @PutMapping("/")
    private Series updateSeries(@RequestBody Series series) {
        return seriesRepository.save(series);
    }
}
