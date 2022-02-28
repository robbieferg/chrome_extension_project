import { useState, useEffect, isValidElement } from "react";
import Rating from "../components/Rating";
import "./InfoContainer.css"
import Request from "../helpers/request";
import Form from "../components/Form";
import $ from 'jquery';
import HoverFunction from "../components/HoverFunction";

const InfoContainer = () => {

    // const [webPages, setWebPages] = useState([]);
    // const [comments, setComments] = useState([]);
    // const [votes, setVotes] = useState([]);
    const [selectedWebPage, setSelectedWebPage] = useState([]);

    let url = window.location.host;
    let urlLink = window.location.pathname;

    const fullUrl = url + urlLink;

    const getUrl = function(){
      fetch(`http://localhost:8080/webpages?url=${url}${urlLink}`)
      .then(res => res.json())
      .then(selectedWebPage => setSelectedWebPage(selectedWebPage[0]))
  }

      const handleWebPagePost = function(webPage){
        const request = new Request();
        request.post("http://www.localhost:8080/webpages", webPage)
<<<<<<< HEAD
        // .then(() => window.location.reload())
=======
>>>>>>> develop
      }

      const handleVotePost = function(vote){
        const request = new Request();
        request.post("http://www.localhost:8080/votes", vote)
        // .then(() => window.location.reload())
      }

      const handleCommentPost = function(props){
        const request = new Request();
<<<<<<< HEAD
        request.post("http://www.localhost:8080/comments", comment)
        // .then(() => window.location.reload())
      }

      const handleFullPost = (webpage, isUpVote, comment) => {
        handleWebPagePost(webpage)
        .then(
          handleCommentPost(
            {
              comment : comment,
              webPage : {
                url: fullUrl
              }
            }
          )
        )
        .then(
          handleVotePost(isUpVote)
        )
=======
        request.post("http://www.localhost:8080/comments", props)
        // .then(() => window.location.reload())
      }

      const handleFullPost = (webpage, vote, comment) => {
        handleWebPagePost(webpage)
          handleCommentPost(
            {
              "text": comment,
              "webPage": {
                "id": 1
              }
            }
          )
          handleVotePost(
            {
              "isUpVote": vote,
              "webPage": {
                "id": 1
              }
            }
          )
          .then(() => window.location.reload())
>>>>>>> develop
      }
      // useEffect(() => {
      //   handleWebPagePost(fullUrl)
      // },[])

      useEffect(()=>{
        getUrl()
      }, [selectedWebPage, getUrl, setSelectedWebPage])

      

    return (
        <>
        <HoverFunction/>

        <div className="navbar-container">
          
          {
            selectedWebPage && false
              ? <Rating selectedWebPage={selectedWebPage}/> 
              : <Form url={url} urlLink={urlLink} handleFullPost={handleFullPost}
              handleComment={handleCommentPost}/>
          }

          <button onClick={() => handleCommentPost("Hello, World")}>A</button>
          
        </div>
        </>
    )
}

export default InfoContainer;