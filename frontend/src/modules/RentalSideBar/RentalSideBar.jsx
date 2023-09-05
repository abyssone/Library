import React, { useContext } from "react";
import { WindowContext, EDIT_WINDOW, CREATE_WINDOW } from "../../pages/RentalCreate";
import styles from "./RentalSideBar.module.css"


const RentalSideBar = function() {
    const [window, setWindow] = useContext(WindowContext);

    return (
        <aside className={styles.sideBar}>
            <div className={`${styles.option} ${window === CREATE_WINDOW && styles.active}`}
                onClick={() => setWindow(CREATE_WINDOW)}
            >Добавить</div>
            <div className={`${styles.option} ${window === EDIT_WINDOW && styles.active}`}
                onClick={() => setWindow(EDIT_WINDOW)}
            >Просмотр</div>
        </aside>
    );
}


export default RentalSideBar;