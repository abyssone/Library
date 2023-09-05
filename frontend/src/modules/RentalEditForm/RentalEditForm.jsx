import React, { useEffect, useState } from "react";

import styles from "./RentalEditForm.module.css"
import { useFormFetch } from "../../utils/hooks/useFormFetch";
import { BackendURL } from "../../config";


const RentalEditForm = function() {
    const [notes, setNotes] = useState();

    useEffect(() => {
        fetch(`${BackendURL}/rental-list`, {
            credentials: 'include'
        }).then(res => res.json())
        .then(data => setNotes(data))
        .catch(err => console.log(err));
    }, []);

    return (
        <div className={styles.editForm}>
            <h3>Таблица проката</h3>
            <table className={styles.table}>
                <thead>
                    <tr>
                        <th>Дата</th>
                        <th>Книга</th>
                        <th>Выдал</th>
                        <th>Получил</th>
                    </tr>
                </thead>
                <tbody>
                    {   notes 
                        ? notes.map(note => <tr>
                            <td>{note.startDate}</td>
                            <td>{note.book?.title}</td>
                            <td>{note.librarian?.email}</td>
                            <td>{note.reader?.email}</td>
                        </tr>)
                        : null
                    }
                </tbody>
            </table>
        </div>
    );
}


export default RentalEditForm;