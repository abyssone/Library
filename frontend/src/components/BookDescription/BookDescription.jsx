import React from "react";
import styles from "./BookDescription.module.css"
import { BackendURL } from "../../config";


const BookDescription = function({book, ...params}) {
    console.log(styles);

    return (
        <div className={styles.page}>
            <div className={styles.container}>
                <div className={styles.book_info_area}>
                    <img 
                        src={`${BackendURL}/images/${book.image.id}`} 
                        alt={book.title} 
                        className={styles.book_image}/>
                    <div className={styles.container_desc}>
                        <p>{book.title}</p>
                        <p>{book.author}</p>
                    </div>
                </div>            
            </div>
        </div>
        
    );
}


export default BookDescription;