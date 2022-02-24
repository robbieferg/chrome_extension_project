import { useState, useEffect } from "react";
import Rating from "../components/Rating";

const InfoContainer = () => {

    const [webPages, setWebPages] = useState([]);
    const [selectedWebPage, setSelectedWebPage] = useState(null);
   

    const requestAll = function(){
        const request = new Request();
        const webPagePromise = request.get('/webpages')
        
    
        Promise.all([webPagePromise])
        .then((data) => {
            setWebPages(data[0]);
            
        })
      }
    
      useEffect(()=>{
        requestAll()
      }, [])

    return (
        <>
        <p>blah</p>
        <Rating webPages = {webPages}/>
        </>
    )
}

export default InfoContainer;