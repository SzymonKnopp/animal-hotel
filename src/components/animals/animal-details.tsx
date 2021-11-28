import {useEffect, useState} from "react";
import {useLocation, useNavigate} from "react-router-dom"
import Header from "../../style-components/header";
import Table from "../../style-components/table";
import {Animal} from "../../rest/animals/contract";
import {serviceGetAnimal} from "../../rest/animals/functions";

export default function AnimalDetails() {
    const navigate = useNavigate();
    const {search} = useLocation();
    const params = new URLSearchParams(search);
    const ownerId = Number.parseInt(params.get("ownerId") ?? "");
    const id = Number.parseInt(params.get("id") ?? "");

    const [animal, setAnimal] = useState<Animal | null>(null);

    useEffect(() => {
        serviceGetAnimal(id).then(animal => setAnimal(animal));
    });

    function goBackToOwnerDetails() {
        navigate(`/owners/details?id=${ownerId}`);
    }

    return (
        <>
            <Header>Animal details</Header>
            <Table>
                <tr>
                    <th>Name</th>
                    <td>{animal?.name}</td>
                </tr>
                <tr>
                    <th>Gender</th>
                    <td>{animal?.gender}</td>
                </tr>
                <tr>
                    <th>Species</th>
                    <td>{animal?.species}</td>
                </tr>
                <tr>
                    <th>Owner</th>
                    <td>{animal?.owner.name + " " + animal?.owner.surname}</td>
                </tr>
            </Table>
            <button onClick={() => goBackToOwnerDetails()}>Return</button>
        </>
    );
}