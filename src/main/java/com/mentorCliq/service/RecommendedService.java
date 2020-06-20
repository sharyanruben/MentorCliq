package com.mentorCliq.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mentorCliq.model.MatchingCombination;

@Service
public class RecommendedService {

    public static final double DELTA = 0.01;

    public List<MatchingCombination> getRecommendedCombinations(List<MatchingCombination> matchingCombinations) {

        Optional<MatchingCombination> max = matchingCombinations.stream().max(Comparator.comparingDouble(MatchingCombination::getAverage));
        if (max.isPresent()) {
            return matchingCombinations.stream()
                    .filter(c -> Math.abs(max.get().getAverage() - c.getAverage()) < DELTA)
                    .collect(Collectors.toList());
        }

        throw new RuntimeException("Can not calculate the combination with the highest average matching.");
    }

}
