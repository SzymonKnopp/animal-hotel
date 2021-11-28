import {useState} from "react";
import {useLocation, useNavigate} from "react-router-dom";
import {Gender} from "../../rest/common/contract";
import {CreateAnimalRequest, Species} from "../../rest/animals/contract";
import {serviceCreateAnimal} from "../../rest/animals/functions";

export default function AddAnimal() {
    const navigate = useNavigate();
    const {search} = useLocation();
    const ownerId = Number.parseInt(new URLSearchParams(search).get("ownerId") ?? "");

    const [form, setForm] = useState<Omit<CreateAnimalRequest, "ownerId">>({
        name: "",
        gender: Gender.MALE,
        species: Species.DOG
    });

    async function addAnimal() {
        await serviceCreateAnimal({...form, ownerId});
        navigate(`/owners/details?id=${ownerId}`);
    }

    return (
        <>
            <h3>Add animal</h3>
            Name:
            <input
                type="text"
                placeholder="Enter name..."
                value={form.name}
                onChange={event => setForm({...form, name: event.target.value})}
            />
            <br/>

            Gender:
            <select onChange={event => setForm({...form, gender: Gender[event.target.value as Gender]})}>
                <option value="MALE">Male</option>
                <option value="FEMALE">Female</option>
            </select>
            <br/>

            Species:
            <select onChange={event => setForm({...form, species: Species[event.target.value as Species]})}>
                {Object.keys(Species).map((species, idx) => (
                    <option key={idx} value={species}>{species}</option>
                ))}
            </select>
            <br/>

            <button onClick={() => addAnimal()}>Confirm</button>
        </>
    )
}