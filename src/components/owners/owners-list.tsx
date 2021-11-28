import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom"
import {AllOwners} from "../../rest/owners/contract";
import {serviceDeleteOwner, serviceGetAllOwners} from "../../rest/owners/functions";

export default function OwnersList() {
    const navigate = useNavigate();
    const [owners, setOwners] = useState<AllOwners>([]);

    useEffect(() => {
        serviceGetAllOwners().then(allOwners => setOwners(allOwners));
    });

    function openOwnerDetailsView(id: number) {
        navigate(`/owners/details?id=${id}`);
    }

    function openEditOwnerView(id: number) {
        navigate(`/owners/edit?id=${id}`);
    }

    async function deleteOwner(id: number) {
        await serviceDeleteOwner(id);
    }

    function openAddOwnerView() {
        navigate("/owners/add");
    }

    return (
        <>
            <h3>Owners</h3>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                </tr>
                {owners.map((owner, idx) => (
                    <tr key={idx}>
                        <td>{owner.name}</td>
                        <td>{owner.surname}</td>
                        <td><button onClick={() => openOwnerDetailsView(owner.id)}>details</button></td>
                        <td><button onClick={() => openEditOwnerView(owner.id)}>edit</button></td>
                        <td><button onClick={() => deleteOwner(owner.id)}>delete</button></td>
                    </tr>
                ))}
            </table>
            <button onClick={() => openAddOwnerView()}>Add owner</button>
        </>
    );
}