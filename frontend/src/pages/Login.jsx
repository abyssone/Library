import React, {useContext, useState} from "react";
import Header from "../components/Header/Header";
import { Link, useNavigate } from 'react-router-dom'
import { BackendURL } from "../config";
import { UserContext } from "../App";
import { Input } from '../components/UI';
import styles from './Login.module.css';


const Login = function() {
    const [login, setLogin] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();
    const {user, setUser} = useContext(UserContext);

    function authorize() {
        fetch(`${BackendURL}/login`, {
            body: `username=${login}&password=${password}`,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            method: 'post',
            credentials: 'include'
        }).then(res => res.json())
        .then(data => {
            setUser(data);
        })
        .then(() => {
            navigate('/', {replace: true});
        })
        .catch(err => console.log(err));
    }

    return (
        <>
            <Header />
            <div className={styles.content}>
                <p>Авторизация</p>
                <Input type="text" 
                    placeholder="Логин" 
                    name="username"
                    value={login}
                    onChange={(e) => setLogin(e.target.value)}/>
                <Input type="text" 
                    placeholder="Пароль" 
                    name="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}/>
                <button 
                    onClick={(e) => {
                    authorize();}}
                >Войти</button>
                <Link to='/registration'>Регистрация</Link>
            </div>            
        </>        
    );
}


export default Login;