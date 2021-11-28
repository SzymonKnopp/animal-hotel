import React from 'react';
import './App.css';
import {Route, Routes} from "react-router-dom";
import OwnersList from "./components/owners/owners-list";
import AddOwner from "./components/owners/add-owner";
import EditOwner from "./components/owners/edit-owner";

export default function App() {
  return (
    <Routes>
        <Route path="/owners" element={<OwnersList/>} />
        <Route path="/owners/add" element={<AddOwner/>} />
        <Route path="/owners/edit" element={<EditOwner/>} />
    </Routes>
  );
}
