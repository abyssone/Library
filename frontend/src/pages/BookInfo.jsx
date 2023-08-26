import React, { useEffect, useState } from "react";
import Header from "../components/Header/Header";
import { useParams } from "react-router-dom";
import { BackendURL } from "../config";
import BookDescription from "../components/BookDescription/BookDescription";


const BookInfo = function() {
    const {id} = useParams();
    const [info, setInfo] = useState();

    useEffect(() => {
        fetch(`${BackendURL}/book/${id}`)
        .then(res => res.json())
        .then(data => setInfo(data))
        .catch(err => console.log(err));
    }, [])

    return (
        <>
        {console.log(id)}
            <Header />
            {
                info
                ? <BookDescription book={info} />
                : null            
            }
        </>
    );
}


export default BookInfo;