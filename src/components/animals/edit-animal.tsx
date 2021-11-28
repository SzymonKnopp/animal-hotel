import {useLocation, useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import {Gender} from "../../rest/common/contract";
import {CreateAnimalRequest, Species} from "../../rest/animals/contract";
import {serviceGetAnimal, serviceUpdateAnimal} from "../../rest/animals/functions";

export default function EditAnimal() {
    const navigate = useNavigate();
    const {search} = useLocation();
    const params = new URLSearchParams(search);
    const ownerId = Number.parseInt(params.get("ownerId") ?? "");
    const id = Number.parseInt(params.get("id") ?? "");

    const [form, setForm] = useState<Omit<CreateAnimalRequest, "ownerId">>({
        name: "",
        gender: Gender.MALE,
        species: Species.DOG
    });

    useEffect(() => {
        serviceGetAnimal(id)
            .then(animal => setForm({name: animal.name, gender: animal.gender, species: animal.species}));
    }, [id]);

    async function editAnimal() {
        await serviceUpdateAnimal(id, {...form, ownerId});
        navigate(`/owners/details?id=${ownerId}`);
    }

    return (
        <>
            <h3>Edit animal</h3>
            Name:
            <input
                type="text"
                placeholder="Enter name..."
                value={form.name}
                onChange={event => setForm({...form, name: event.target.value})}
            />
            <br/>

            Gender:
            <select
                value={form.gender}
                onChange={event => setForm({...form, gender: Gender[event.target.value as Gender]})}>
                <option value="MALE">Male</option>
                <option value="FEMALE">Female</option>
            </select>
            <br/>

            Species:
            <select
                value={form.species}
                onChange={event => setForm({...form, species: Species[event.target.value as Species]})}
            >
                {Object.keys(Species).map((species, idx) => (
                    <option key={idx} value={species}>{species}</option>
                ))}
            </select>
            <br/>

            <button onClick={() => editAnimal()}>Confirm</button>
        </>
    )
}