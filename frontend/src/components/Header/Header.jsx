import React, { useContext } from "react";
import styles from './Header.module.css';
import { UserContext } from "../../App";
import logo from '../../img/Logo.png';
import { Link } from "react-router-dom";
import { GrUserAdmin, GrUserExpert } from "react-icons/gr";
import { BackendURL } from "../../config";


const Header = function() {
    const {user, setUser} = useContext(UserContext);

    function logout() {
        fetch(`${BackendURL}/logout`, {credentials: 'include'})
        .then(setUser(null))
        .catch(err => console.log(err));
    }

    return (
        <div className={styles.header}>
            <div className={styles.content}>
                <div className={styles.logo}>
                    <Link to='/'>
                        <img src={logo} alt="LitHub" />
                    </Link>
                </div>
                <div className={styles.navbar}>
                    <p className={styles.item}><a href="/login">Контакты</a></p>
                    <p className={styles.item}><a href="/login">О нас</a></p>
                    {
                        user?.name
                        ? <nav className={styles.item_name}>
                            {user.name}
                            {
                                user.authorities.includes('ROLE_ADMIN')
                                ? <GrUserAdmin style={{marginLeft: '5px'}}/>
                                : <GrUserExpert style={{marginLeft: '5px'}}/>
                            }                            
                            <ul className={styles.item_menu}>
                                <li>Личный кабинет</li>
                                {
                                user.authorities.includes('ROLE_ADMIN')
                                ? <>
                                    <Link to='/admin'><li>Админ панель</li></Link>
                                    <Link to='/book/create'><li>Добавление книг</li></Link>
                                    <Link to='/rental/create'><li>Прокат</li></Link>
                                  </>                                    
                                : <li>Мои книги</li>
                                }  
                                <li>Мои книги</li>
                                <li onClick={() => logout()}>Выйти</li>
                            </ul>
                        </nav>
                        : <p className={styles.item}><a href="/login">Войти</a></p>
                    }
                </div>
            </div>         
        </div>
    );
}


export default Header;