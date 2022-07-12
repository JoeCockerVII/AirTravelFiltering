package com.gridnine.testing.domain.entity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 */
public class Flight {
    private final List<Segment> segments;
    private final UUID id;

    public Flight(final List<Segment> segs) {
        segments = segs;
        id = UUID.randomUUID();
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}