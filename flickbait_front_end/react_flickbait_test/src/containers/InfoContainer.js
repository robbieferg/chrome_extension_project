import { useState, useEffect } from "react";
import Rating from "../components/Rating";
import "./InfoContainer.css"
import Request from "../helpers/request";
import Form from "../components/Form";

const InfoContainer = () => {

    const [webPages, setWebPages] = useState([]);
    const [comments, setComments] = useState([]);
    const [votes, setVotes] = useState([]);
    const [selectedWebPage, setSelectedWebPage] = useState([]);

    let url = window.location.host;
    let urlLink = window.location.pathname;

    const getUrl = function(){
      fetch(`http://localhost:8080/webpages?url=${url}${urlLink}`)
      .then(res => res.json())
      .then(selectedWebPage => setSelectedWebPage(selectedWebPage[0]))
  }
   

      const handleWebPagePost = function(webPage){
        const request = new Request();
        request.post("http://www.localhost:8080/webpages", webPage)
        // .then(() => window.location = 'http://www.localhost:8080/webpages')
      }

      const handleVotePost = function(vote){
        const request = new Request();
        request.post("http://www.localhost:8080/votes", vote)
        // .then(() => window.location = 'http://www.localhost:8080/votes')
      }

      const handleCommentPost = function(comment){
        const request = new Request();
        request.post("http://www.localhost:8080/comments", comment)
        // .then(() => window.location = 'http://www.localhost:8080/comments')
      }

    
      useEffect(()=>{
        getUrl()
      }, [selectedWebPage])

    return (
        <>
        <div className="navbar-container">
          
          {selectedWebPage ? <Rating selectedWebPage={selectedWebPage}/> : <Form url={url} urlLink={urlLink} onWebPageCreate={handleWebPagePost} onVoteCreate={handleVotePost} onCommentCreate={handleCommentPost}/>}
          
        </div>
        </>
    )
}

export default InfoContainer;