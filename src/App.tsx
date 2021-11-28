import React from 'react';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import OwnersList from "./components/owners/owners-list";
import AddOwner from "./components/owners/add-owner";
import EditOwner from "./components/owners/edit-owner";
import OwnerDetails from "./components/owners/owner-details";
import AnimalDetails from "./components/animals/animal-details";
import AddAnimal from "./components/animals/add-animal";
import EditAnimal from "./components/animals/edit-animal";

export default function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<OwnersList/>}/>
            <Route path="/owners" element={<OwnersList/>} />
            <Route path="/owners/details" element={<OwnerDetails/>} />
            <Route path="/owners/add" element={<AddOwner/>} />
            <Route path="/owners/edit" element={<EditOwner/>} />
            <Route path="/animals/details" element={<AnimalDetails/>} />
            <Route path="/animals/add" element={<AddAnimal/>} />
            <Route path="/animals/edit" element={<EditAnimal/>} />
        </Routes>
    </BrowserRouter>
  );
}

