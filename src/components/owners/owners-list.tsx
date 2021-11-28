import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom"
import {AllOwners} from "../../rest/owners/contract";
import {serviceDeleteOwner, serviceGetAllOwners} from "../../rest/owners/functions";
import Header from "../../style-components/header";
import Table from "../../style-components/table";

export default function OwnersList() {
    const navigate = useNavigate();
    const [owners, setOwners] = useState<AllOwners>([]);

    useEffect(() => {
        serviceGetAllOwners().then(allOwners => setOwners(allOwners));
    });

    async function deleteOwner(id: number) {
        await serviceDeleteOwner(id);
    }

    async function openAddOwnerView() {
        navigate("/owners/add");
    }

    async function openEditOwnerView(id: number) {
        navigate(`/owners/edit?id=${id}`);
    }

    return (
        <>
            <Header>Owners</Header>
            <Table>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                </tr>
                {owners.map(owner => (
                    <tr>
                        <td>{owner.name}</td>
                        <td>{owner.surname}</td>
                        <td><button onClick={() => openEditOwnerView(owner.id)}>edit</button></td>
                        <td><button onClick={() => deleteOwner(owner.id)}>delete</button></td>
                    </tr>
                ))}
            </Table>
            <button onClick={() => openAddOwnerView()}>Add owner</button>
        </>
    );
}