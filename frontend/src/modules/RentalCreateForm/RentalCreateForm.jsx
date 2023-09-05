import React, {useEffect, useState} from "react";
import { Input } from "../../components/UI";

import styles from "./RentalCreateForm.module.css"
import { useFormFetch } from "../../utils/hooks/useFormFetch";


const RentalCreateForm = function() {
    const [form, setForm] = useState({
        bookTitle: '',
        readerEmail: ''
    });
    const [fetchForm, response] = useFormFetch();

    useEffect(() => {console.log(response)}, [response]);

    return (
        <div>
            <Input placeholder='Название книги' 
                value={form.bookTitle}
                onChange={(e) => setForm({...form, bookTitle: e.target.value})}/>
            <Input placeholder='Email читателя'
                value={form.readerEmail}
                onChange={(e) => setForm({...form, readerEmail: e.target.value})}/>
            <button onClick={() => fetchForm('rental', form)}>Добавить</button>
        </div>
    );
}


export default RentalCreateForm;