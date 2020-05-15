package com.company.lesson1505;

public class Fish {
    int weight;
    SortFish sort;

    public Fish(int weight, SortFish sort) {
        this.weight = weight;
        this.sort = sort;
    }
}
enum SortFish{
    Karp,Sudak,Okun,Shuka
}