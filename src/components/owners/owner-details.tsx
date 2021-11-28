import {useEffect, useState} from "react";
import {useLocation, useNavigate} from "react-router-dom"
import {Owner} from "../../rest/owners/contract";
import {serviceGetOwner} from "../../rest/owners/functions";
import Header from "../../style-components/header";
import Table from "../../style-components/table";
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
            <Header>Owner details</Header>
            <Table>
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
            </Table>
            <br/>
            <OwnedAnimalsList owner={owner}/>
            <button onClick={() => goBackToOwnerList()}>Return</button>
        </>
    );
}