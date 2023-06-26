package ru.shrf.testjob.services;

import lombok.Getter;

@Getter
public enum RatingEnum {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int value;
    RatingEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
