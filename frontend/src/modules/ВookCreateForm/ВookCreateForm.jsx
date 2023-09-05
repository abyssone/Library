import React, {useState} from "react";
import { Input } from "../../components/UI";
import { useFormFetch } from "../../utils/hooks/useFormFetch";


export const ВookCreateForm = () => {
    const [bookForm, setBookForm] = useState({
        title: '',
        author: '',
        publicationYear: '',
        imageFile: ''
    });

    const [fetchForm, response] = useFormFetch();

    return (
        <>
            <Input placeholder='Название'
                    value={bookForm.title}
                    onChange={(e) => setBookForm({...bookForm, title: e.target.value})}/>
            <Input placeholder='Автор'
                value={bookForm.author}
                onChange={(e) => setBookForm({...bookForm, author: e.target.value})}/>
            <Input placeholder='Год публикации'
                value={bookForm.publicationYear}
                onChange={(e) => setBookForm({...bookForm, publicationYear: e.target.value})}/>
            <Input type="file" 
                placeholder='Обложка'
                onChange={(e) => {
                    setBookForm({...bookForm, imageFile: e.target.files[0]});
                    console.log(e.target.files);
                }}/>
            <button onClick={() => fetchForm('bookcreate', bookForm)}>Отправить</button>
        </>
    );
}