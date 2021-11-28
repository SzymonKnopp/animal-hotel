import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {CreateOwnerRequest} from "../../rest/owners/contract";
import {Gender} from "../../rest/common/contract";
import {serviceCreateOwner} from "../../rest/owners/functions";

export default function AddOwner() {
    const navigate = useNavigate();
    const [form, setForm] = useState<CreateOwnerRequest>({name: "", surname: "", gender: Gender.MALE});

    async function addOwner() {
        await serviceCreateOwner(form);
        navigate("/owners");
    }

    return (
        <>
            <h3>Add owner</h3>
            Name:
            <input
            type="text"
            placeholder="Enter name..."
            value={form.name}
            onChange={event => setForm({...form, name: event.target.value})}
            />
            <br/>


            Surname:
            <input
                type="text"
                placeholder="Enter surname..."
                value={form.surname}
                onChange={event => setForm({...form, surname: event.target.value})}
            />
            <br/>

            Gender:
            <select onChange={event => setForm({...form, gender: Gender[event.target.value as "MALE" | "FEMALE"]})}>
                <option value="MALE">Male</option>
                <option value="FEMALE">Female</option>
            </select>
            <br/>

            <button onClick={() => addOwner()}>Confirm</button>
        </>
    )
}