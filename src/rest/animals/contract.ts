import {Gender} from "../common/contract";
import {Owner} from "../owners/contract";

export enum Species {
    DOG = "DOG",
    CAT = "CAT",
    PARROT = "PARROT",
    SNAKE = "SNAKE",
    HAMSTER = "HAMSTER",
    RAT = "RAT",
    GUINEA_PIG = "GUINEA_PIG",
    WOMBAT = "WOMBAT"
}

export type Animal = {
    id: number,
    name: string,
    species: Species,
    gender: Gender,
    owner: Owner
};

export type AllAnimals = {
    id: number,
    name: string
}[];

export type CreateAnimalRequest = {
    name: string,
    species: Species,
    gender: Gender,
    ownerId: number
};

export type UpdateAnimalRequest = {
    name: string,
    species: Species,
    gender: Gender,
    ownerId: number
};