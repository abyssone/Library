import React, { useState } from "react";
import Header from "../components/Header/Header";
import { Input } from "../components/UI";
import { BackendURL } from "../config";


const Registration = function() {
    const [formData, setFormData] = useState({name: '', email: '', password: ''})

    function fetchForm() {
        fetch(`${BackendURL}/registration`, 
        {
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            method: 'POST',
            body: `name=${formData.name}&email=${formData.email}&password=${formData.password}`
        }).then(res => console.log(res))
        .catch(err => console.log(err));
    }

    return (
        <>
            <Header />
            <Input placeholder='Имя' 
                value={formData.name} 
                onChange={(e) => setFormData({...formData, name: e.target.value})}/>
            <Input placeholder='Email'
                value={formData.email} 
                onChange={(e) => setFormData({...formData, email: e.target.value})}/>
            <Input placeholder='Пароль'
                value={formData.password} 
                onChange={(e) => setFormData({...formData, password: e.target.value})}/>
            <button onClick={() => fetchForm()}>Отправить</button>
        </>
    );
}


export default Registration;