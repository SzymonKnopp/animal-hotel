import {Owner} from "../../rest/owners/contract";
import {serviceDeleteAnimal, serviceGetAllAnimals, serviceGetAnimal} from "../../rest/animals/functions";
import {useEffect, useState} from "react";
import {AllAnimals} from "../../rest/animals/contract";
import {useNavigate} from "react-router-dom";

export default function OwnedAnimalsList({owner}: {owner: Owner | null}) {
    const navigate = useNavigate();
    const [animals, setAnimals] = useState<AllAnimals>([]);

    useEffect(() => {
        serviceGetAllAnimals().then(allAnimals => allAnimals.forEach(animal => {
            serviceGetAnimal(animal.id).then(animal => {
                if (animal.owner.id === owner?.id) setAnimals(animals => [...animals, animal]);
            });
        }));
    }, [owner?.id]);

    function openAnimalDetailsView(id: number) {
        navigate(`/animals/details?ownerId=${owner?.id}&id=${id}`);
    }

    function openEditAnimalView(id: number) {
        navigate(`/animals/edit?ownerId=${owner?.id}&id=${id}`);
    }

    async function deleteAnimal(id: number) {
        setAnimals(animals.filter(animal => animal.id !== id));
        await serviceDeleteAnimal(id);
    }

    function openAddAnimalView() {
        navigate(`/animals/add?ownerId=${owner?.id}`);
    }

    return (
        <>
            <h3>Owned animals</h3>
            {animals.length > 0 ? (
                <table>
                    <tr>
                        <th>Name</th>
                    </tr>
                    {animals.map((animal, idx) => (
                        <tr key={idx}>
                            <td>{animal.name}</td>
                            <td><button onClick={() => openAnimalDetailsView(animal.id)}>details</button></td>
                            <td><button onClick={() => openEditAnimalView(animal.id)}>edit</button></td>
                            <td><button onClick={() => deleteAnimal(animal.id)}>delete</button></td>
                        </tr>
                    ))}
                </table>
            ) : (
                <>
                    <i>none</i>
                    <br/>
                </>
            )}
            <button onClick={() => openAddAnimalView()}>Add animal</button>
        </>
    );
}