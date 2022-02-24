import { useState, useEffect } from "react";
import Rating from "../components/Rating";

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
        <p>blah</p>
        <Rating selectedWebPage={selectedWebPage}/>
        </>
    )
}

export default InfoContainer;