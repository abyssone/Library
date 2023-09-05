import React, {useState, useEffect} from "react";
import Header from "../components/Header/Header";
import CardContainer from "../components/CardContainer/CardContainer";
import BookFilterPanel from "../modules/BookFilterPanel/BookFilterPanel";
import styles from './Homepage.module.css';


const Homepage = function() {
    const [bookList, setBookList] = useState([]);
    const [search, setSearch] = useState('');

    function fetchToBack() {
      fetch(`http://localhost:8080${search ? `?title=${search}` : ''}`, {
          credentials: 'include'
        })
        .then(response => response.json())
        .then(data => setBookList(data))
        .catch(e => console.log(e));
    }
  
    useEffect(() => {
      fetchToBack();
    }, [])
  
    return (
      <div className="App">
        <Header />
        <div className={styles.main}>
          <BookFilterPanel search={{search, setSearch}} filter={fetchToBack}/>
          <CardContainer bookList={bookList} />
        </div>
      </div>
    );
}


export default Homepage;