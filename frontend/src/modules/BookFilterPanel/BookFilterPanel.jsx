import React from "react";

import styles from "./BookFilterPanel.module.css"
import { Input } from "../../components/UI";


const BookFilterPanel = function({search, filter, ...props}) {


    return (
        <aside className={styles.panel}>
            <Input placeholder='Поиск' value={search.search}
                onChange={(e) => search.setSearch(e.target.value)}
                onKeyDown={(e) => {
                    if (e.key === 'Enter') filter();
                }}/>
            <p className={styles.searchOptions}>Поиск по 
                <select name="" id="">
                    <option value="">Названию</option>
                    <option value="">Автору</option>
                    <option value="">Году публикации</option>
                </select>
            </p>
        </aside>
    );
}


export default BookFilterPanel;