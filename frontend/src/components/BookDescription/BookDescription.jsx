import React from "react";
import styles from "./BookDescription.module.css"
import { BackendURL } from "../../config";


const BookDescription = function({book, ...params}) {


    return (
        <div className={styles.container}>
            <img 
                src={`${BackendURL}/images/${book.image.id}`} 
                alt={book.title} 
                className={styles.container_image}/>
            <div className={styles.container_desc}>
                <p>{book.title}</p>
                <p>{book.author}</p>
            </div>
        </div>
    );
}


export default BookDescription;