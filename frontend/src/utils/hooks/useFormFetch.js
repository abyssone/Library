import React, { useState } from "react"
import { BackendURL } from "../../config";


export const useFormFetch = () => {
    const [response, setResponse] = useState();    

    function fetchForm(url, dataObj) {
        if(!dataObj || Object.keys(dataObj).length === 0) return;

        const form = new FormData();

        for(let key of Object.keys(dataObj)) {
            form.append(key, dataObj[key]);
        }
        fetch(`${BackendURL}/${url}`, {
            method: 'POST',
            credentials: 'include',
            body: form
        }).then(res => setResponse(res))
        .catch(err => console.log(err));        
    }

    return [fetchForm, response];
}