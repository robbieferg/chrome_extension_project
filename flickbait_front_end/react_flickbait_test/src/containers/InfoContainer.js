import { useState, useEffect, isValidElement } from "react";
import Rating from "../components/Rating";
import "./InfoContainer.css"
import Request from "../helpers/request";
import Form from "../components/Form";
import HoverFunction from "../components/HoverFunction";
import $ from 'jquery';

const InfoContainer = () => {

    // const [webPages, setWebPages] = useState([]);
    // const [comments, setComments] = useState([]);
    const [votes, setVotes] = useState([]);
    const [selectedWebPage, setSelectedWebPage] = useState([]);
    const [latestVote, setLatestVote] = useState([]);

    
    let url = window.location.host;
    let urlLink = window.location.pathname;
    
    const fullUrl = url + urlLink;
    
    const getUrl = function(){
      fetch(`http://localhost:8080/webpages?url=${fullUrl}`)
      .then(res => res.json())
      .then(selectedWebPage123 => setSelectedWebPage(selectedWebPage123[0]))
    }
    
    const getVotes = function(){
      fetch(`http://localhost:8080/votes/webpages?url=${fullUrl}`)
      .then(res => res.json())
      .then(voteList => setVotes(voteList))
    }
    
    const handleWebPagePost = function(webPage){
        const request = new Request();
        request.post("http://www.localhost:8080/webpages", webPage)
        .then(() => window.location.reload())
      }

      const handleWebPagePut = function(webpage) {
        const request = new Request();
        request.put(`http://www.localhost:8080/webpages/${selectedWebPage.id}`, webpage)
      }
      
      const handleVotePost = function(vote){
        const request = new Request();
        request.post("http://www.localhost:8080/votes", vote)
        .then(setLatestVote(vote))
        // .then(() => window.location.reload())
      }
      
      const handleCommentPost = function(props){
        const request = new Request();
        request.post("http://www.localhost:8080/comments", props)
        // .then(() => window.location.reload())
      }
      
      const addVote= (vote) => {
        if (vote.upVote == true) {
            selectedWebPage.upvotes += 1;
        }
        else {
            selectedWebPage.downvotes += 1;
        }
      }

      const handleFullPost = (website, vote, comment) => {
        console.log(vote);
        handleCommentPost(
          {
            "text": comment,
            "webPage": {
              "id": selectedWebPage.id
            }
          }
          )
          handleVotePost(
            {
              "upVote": vote,
              "webPage": {
                "id": selectedWebPage.id
              }
            }
          )
          .then(() => window.location.reload())
      }
      // useEffect(() => {
      //   handleWebPagePost(fullUrl)
      // },[])

      useEffect(()=>{
        getUrl()
        console.log("first use effect triggered")
      }, [])

      useEffect(() => {
        if(!selectedWebPage) {
          console.log("second use effect triggered")
          handleWebPagePost(fullUrl)
        }
        getVotes()
      },[selectedWebPage])

      // useEffect(() => {
      //   handleWebPagePut(selectedWebPage)
      // },[votes])

      useEffect(() => {
        addVote(latestVote) 
        handleWebPagePut(selectedWebPage)
      },[latestVote])
      
      

    return (
        <>
        <HoverFunction/>

          <div className="navbar-container"> 
            {selectedWebPage && <Rating selectedWebPage={selectedWebPage}
            votes={votes} url={fullUrl}/>}
              <div className="form-container">
                <Form url={url} urlLink={urlLink} handleFullPost={handleFullPost}
                handleComment={handleCommentPost} selectedWebPage={selectedWebPage}/>
              </div>
          </div>
        </>
    )
}

export default InfoContainer;