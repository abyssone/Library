import React from "react";
import styles from './CardContainer.module.css';
import BookCard from "../BookCard/BookCard";


const CardContainer = function({bookList, ...props}) {


    return (
        <div className={styles.cardContainer}>
            {
                bookList.map(book => <BookCard
                key={book.id}
                id={book.id}
                title={book.title}
                author={book.author}
                imageId={book.image.id}
                />)
            }
        </div>
    );
}


export default CardContainer;