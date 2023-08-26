import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Homepage from './pages/Homepage';
import Login from './pages/Login';
import BookInfo from './pages/BookInfo';
import { createContext, useContext, useEffect, useState } from 'react';
import { BackendURL } from './config';
import Registration from './pages/Registration';
import BookCreate from './pages/BookCreate';
import RentalCreate from './pages/RentalCreate';

export const UserContext = createContext(null);

function App() {
  const [user, setUser] = useState();
  useEffect(() => {console.log(user)}, [user])
  useEffect(() => {
    fetch(`${BackendURL}/user/roles`, {credentials: 'include'})
      .then(res => res.json())
      .then(data => setUser(data))
      .catch(err => console.log(err));
  }, []);

  return (
    <UserContext.Provider value={{user, setUser}}>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={ <Homepage /> } />
          <Route path='/login' element={ <Login /> } />
          <Route path='/book'>
            <Route path='create' element={<BookCreate />}/>
            <Route path=':id' element={<BookInfo />} />
          </Route>
          <Route path='/registration' element={ <Registration /> } />
          <Route path='/rental/create' element={ <RentalCreate /> } />
        </Routes>
        </BrowserRouter>
    </UserContext.Provider>
    
  )
}

export default App;
