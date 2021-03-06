package com.chookie.sense.mood;

import java.util.Set;

import static java.util.stream.Collectors.joining;

public class MoodyMessage {
    private final Set<Mood> moods;

    MoodyMessage(Set<Mood> moods) {
        this.moods = moods;
    }

    public boolean hasMood(Mood mood) {
        return moods.contains(mood);
    }

    @Override
    public String toString() {

        String result = moods.stream()
                .map(Enum::toString)
                .collect(joining(","));
        System.out.println("MoodyMessage=" + result);
        return result;
    }

}
