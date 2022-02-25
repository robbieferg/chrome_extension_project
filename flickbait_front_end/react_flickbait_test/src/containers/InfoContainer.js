import { useState, useEffect } from "react";
import Rating from "../components/Rating";
import "./InfoContainer.css"

const InfoContainer = () => {

    const [webPages, setWebPages] = useState([]);
    const [selectedWebPage, setSelectedWebPage] = useState([]);


    let url = window.location.host;
    let urlLink = window.location.pathname;

    const getUrl = function(){
      fetch(`http://localhost:8080/webpages?url=${url}${urlLink}`)
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
      }, [selectedWebPage])

    return (
        <>
        <div className="navbar-container">
          {selectedWebPage ? <Rating selectedWebPage={selectedWebPage}/> : "ERR: Webpage not Registered"}
          
        </div>
        </>
    )
}

export default InfoContainer;