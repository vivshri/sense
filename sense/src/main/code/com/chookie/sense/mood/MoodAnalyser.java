package com.chookie.sense.mood;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.chookie.sense.mood.Mood.HAPPY;
import static com.chookie.sense.mood.Mood.SAD;
import static com.chookie.sense.twitter.TweetParser.getTweetMessageFrom;
import static java.util.stream.Collectors.toSet;

public class MoodAnalyser {
    private static final Map<String, Mood> WORD_TO_MOOD = new HashMap<>();

    static {
        WORD_TO_MOOD.put("happy", HAPPY);
        WORD_TO_MOOD.put("good", HAPPY);
        WORD_TO_MOOD.put("great", HAPPY);
        WORD_TO_MOOD.put("keen", HAPPY);
        WORD_TO_MOOD.put("awesome", HAPPY);
        WORD_TO_MOOD.put("marvelous", HAPPY);
        WORD_TO_MOOD.put("yay", HAPPY);
        WORD_TO_MOOD.put("pleased", HAPPY);
        WORD_TO_MOOD.put("sad", SAD);
        WORD_TO_MOOD.put("mad", SAD);
        WORD_TO_MOOD.put("blargh", SAD);
        WORD_TO_MOOD.put("boo", SAD);
        WORD_TO_MOOD.put("terrible", SAD);
        WORD_TO_MOOD.put("horrible", SAD);
        WORD_TO_MOOD.put("bad", SAD);
        WORD_TO_MOOD.put("awful", SAD);
    }

    private MoodAnalyser() {
    }

    public static MoodyMessage analyseMood(String fullMessage) {
        String[] wordsInMessage = getTweetMessageFrom(fullMessage).split(" ");
        //TODO: figure out the moods in this message
        Set<Mood> moods = Stream.of(wordsInMessage)
                .map(String::toLowerCase)
                .map(WORD_TO_MOOD::get)
                .filter(Objects::nonNull)
                .collect(toSet());
        return new MoodyMessage(moods);
    }
}
