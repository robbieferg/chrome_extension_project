/* global chrome */
import React, {useState, useEffect} from "react";
// import { localMode } from "./constants";

const Popup = () => {

    const [comments, setComments] = useState([]);

    let url = window.location.host;
    let urlLink = window.location.pathname;
    const fullUrl = url + urlLink;

    const getComments = function(){
        fetch(`http://localhost:8080/comments/webpages?url=${fullUrl}`)
        .then(res => res.json())
        .then(comments => setComments(comments))
    }

    useEffect(() => {
        getComments()
    }, [])

    return (
        <div>
            <h1>Comments</h1>
        </div>
    );
}
 
export default Popup;