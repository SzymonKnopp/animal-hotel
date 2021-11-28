import {useEffect, useState} from "react";
import {useLocation, useNavigate} from "react-router-dom"
import {Owner} from "../../rest/owners/contract";
import {serviceGetOwner} from "../../rest/owners/functions";
import OwnedAnimalsList from "../animals/owned-animals-list";

export default function OwnerDetails() {
    const navigate = useNavigate();
    const {search} = useLocation();
    const id = Number.parseInt(new URLSearchParams(search).get("id") ?? "");

    const [owner, setOwner] = useState<Owner | null>(null);

    useEffect(() => {
        serviceGetOwner(id).then(owner => setOwner(owner));
    });

    function goBackToOwnerList() {
        navigate("/owners");
    }

    return (
        <>
            <h3>Owner details</h3>
            <table>
                <tr>
                    <th>Name</th>
                    <td>{owner?.name}</td>
                </tr>
                <tr>
                    <th>Surname</th>
                    <td>{owner?.surname}</td>
                </tr>
                <tr>
                    <th>Gender</th>
                    <td>{owner?.gender}</td>
                </tr>
            </table>
            <br/>
            <OwnedAnimalsList owner={owner}/>
            <button onClick={() => goBackToOwnerList()}>Return</button>
        </>
    );
}