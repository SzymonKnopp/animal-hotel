import {useLocation, useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import {CreateOwnerRequest} from "../../rest/owners/contract";
import {Gender} from "../../rest/common/contract";
import {serviceGetOwner, serviceUpdateOwner} from "../../rest/owners/functions";

export default function EditOwner() {
    const navigate = useNavigate();
    const {search} = useLocation();
    const id = Number.parseInt(new URLSearchParams(search).get("id") ?? "");

    const [form, setForm] = useState<CreateOwnerRequest>({name: "", surname: "", gender: Gender.MALE});

    useEffect(() => {
        serviceGetOwner(id)
            .then(owner => setForm(owner))
    }, [id]);

    async function editOwner() {
        await serviceUpdateOwner(id, form);
        navigate("/owners");
    }

    return (
        <>
            <h3>Edit owner</h3>
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
            <select
                value={form.gender}
                onChange={event => setForm({...form, gender: Gender[event.target.value as Gender]})}>
                <option value="MALE">Male</option>
                <option value="FEMALE">Female</option>
            </select>
            <br/>

            <button onClick={() => editOwner()}>Confirm</button>
        </>
    )
}