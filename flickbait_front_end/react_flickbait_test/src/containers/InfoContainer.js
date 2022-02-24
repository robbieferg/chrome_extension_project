import { useState, useEffect } from "react";
import Rating from "../components/Rating";

const InfoContainer = () => {

    const [webPages, setWebPages] = useState([]);
    const [selectedWebPage, setSelectedWebPage] = useState(null);


    let url = 'http://soundcloud.com/kleyna'
    const getUrl = function(){
      fetch(`http://localhost:8080/webpages?url=http://soundcloud.com/kleyna`)
      .then(res => res.json())
      .then(selectedWebPage => setSelectedWebPage(selectedWebPage))
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
        {/* <Rating selectedWebPage = {selectedWebPage}/> */}
        {selectedWebPage.url}
        </>
    )
}

export default InfoContainer;