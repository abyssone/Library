import React, { createContext, useState } from "react";
import Header from "../components/Header/Header";
import RentalCreateForm from "../modules/RentalCreateForm/RentalCreateForm";
import RentalSideBar from "../modules/RentalSideBar/RentalSideBar";
import styles from './RentalCreate.module.css';
import RentalEditForm from "../modules/RentalEditForm/RentalEditForm";

export const WindowContext = createContext(null);
export const CREATE_WINDOW = 'CREATE_WINDOW';
export const EDIT_WINDOW = 'EDIT_WINDOW';

const RentalCreate = function() {
    const [window, setWindow] = useState(CREATE_WINDOW);

    return (
        <>
            <WindowContext.Provider value={[window, setWindow]}>
                <Header />
                <div className={styles.content}>
                    <RentalSideBar />
                    {
                        window === CREATE_WINDOW
                        ? <RentalCreateForm />
                        : <RentalEditForm />
                    }                    
                </div>
            </WindowContext.Provider>
        </>
    );
}


export default RentalCreate;