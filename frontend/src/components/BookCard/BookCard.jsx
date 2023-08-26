import React from "react";
import styles from './BookCard.module.css'
import { Link } from "react-router-dom";
import { BackendURL } from "../../config";


const BookCard = function({id, title, author, imageId, ...props}) {

    return (
        <Link to={`/book/${id}`}>
            <div className={styles.card}>
                <img className={styles.card_image} src={`${BackendURL}/images/${imageId}`} alt={title} />
                <p className={styles.card_title}>{title}</p>
                <p>{author}</p>
            </div>
        </Link>
        
    );
}


export default BookCard;