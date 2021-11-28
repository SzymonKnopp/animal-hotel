import {REST_GATEWAY_URL} from "../../configuration";
import {AllAnimals, CreateAnimalRequest, Animal, UpdateAnimalRequest} from "./contract";

export async function serviceGetAllAnimals(): Promise<AllAnimals> {
    return fetch(`${REST_GATEWAY_URL}/animals`)
        .then(response => response.json())
        .then(object => object.allAnimals);
}

export async function serviceGetAnimal(id: number): Promise<Animal> {
    return fetch(`${REST_GATEWAY_URL}/animals/${id}`)
        .then(response => response.json());
}

export async function serviceCreateAnimal(newAnimal: CreateAnimalRequest) {
    await fetch(`${REST_GATEWAY_URL}/animals`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newAnimal)
    });
}

export async function serviceUpdateAnimal(id: number, modifiedAnimal: UpdateAnimalRequest) {
    await fetch(`${REST_GATEWAY_URL}/animals/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(modifiedAnimal)
    });
}

export async function serviceDeleteAnimal(id: number) {
    await fetch(`${REST_GATEWAY_URL}/animals/${id}`, {
        method: "DELETE"
    });
}