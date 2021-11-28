import {REST_GATEWAY_URL} from "../../configuration";
import {AllOwners, CreateOwnerRequest, Owner, UpdateOwnerRequest} from "./contract";

export async function serviceGetAllOwners(): Promise<AllOwners> {
    return fetch(`${REST_GATEWAY_URL}/owners`)
        .then(response => response.json())
        .then(object => object.allOwners);
}

export async function serviceGetOwner(id: number): Promise<Owner> {
    return fetch(`${REST_GATEWAY_URL}/owners/${id}`)
        .then(response => response.json());
}

export async function serviceCreateOwner(newOwner: CreateOwnerRequest) {
    await fetch(`${REST_GATEWAY_URL}/owners`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newOwner)
    });
}

export async function serviceUpdateOwner(id: number, modifiedOwner: UpdateOwnerRequest) {
    await fetch(`${REST_GATEWAY_URL}/owners/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(modifiedOwner)
    });
}

export async function serviceDeleteOwner(id: number) {
    await fetch(`${REST_GATEWAY_URL}/owners/${id}`, {
        method: "DELETE"
    });
}