import React, {useState} from "react";
import Header from "../components/Header/Header";
import { ВookCreateForm } from '../modules';


const BookCreate = function() {

    return (
        <>
            <Header />
            <ВookCreateForm />    
        </>
    );
}


export default BookCreate;