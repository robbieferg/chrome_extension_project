import { useState, useEffect } from "react";
import Rating from "../components/Rating";
import "./InfoContainer.css"

const InfoContainer = () => {

    const [webPages, setWebPages] = useState([]);
    const [selectedWebPage, setSelectedWebPage] = useState([]);


    let url = 'http://soundcloud.com/kleyna'
    const getUrl = function(){
      fetch(`http://localhost:8080/webpages?url=${url}`)
      .then(res => res.json())
      .then(selectedWebPage => setSelectedWebPage(selectedWebPage[0]))
  }
   

    // const requestAll = function(){
    //     const request = new Request();
    //     const webPagePromise = request.get('/webpages')
        
    
      //   Promise.all([webPagePromise])
      //   .then((data) => {
      //       setWebPages(data[0]);
            
      //   })
      // }
    
      useEffect(()=>{
        getUrl()
      }, [])

    return (
        <>
        <div className="navbar-container">
          <p>blah</p>
          <Rating selectedWebPage={selectedWebPage}/>
        </div>
        </>
    )
}

export default InfoContainer;