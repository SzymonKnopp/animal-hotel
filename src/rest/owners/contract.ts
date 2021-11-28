import {Gender} from "../common/contract";

export type Owner = {
    id: number,
    name: string,
    surname: string,
    gender: Gender
};

export type AllOwners = {
    id: number,
    name: string,
    surname: string
}[];

export type CreateOwnerRequest = {
    name: string,
    surname: string,
    gender: Gender
};

export type UpdateOwnerRequest = {
    name: string,
    surname: string,
    gender: Gender
};