import React, { useState, useEffect } from 'react';
import "./HoverFunction.css";
// import Request from "../helpers/request";
import $ from 'jquery';

const HoverFunction = ({logo, text}) => {

  const [hoverHref, setHoverHref] = useState("");
  const [link, setLink] = useState([{}]);

  const trimHref = hoverHref.replace(/^https?\:\/\//i, "") ?? "";

  const ratingString = link?.[0]?.averageRating?.toString() ?? "" + "";
  const stringLength = 5;

  const percentageRating = ratingString?.substring(0, stringLength) ?? "No Data";
  const numberOfVotes = (link?.[0]?.upvotes ?? 0) + (link?.[0]?.downvotes ?? 0);

  const getUrl = () => {
    // console.log(`http://localhost:8080/webpages?url=${trimHref}`)
    fetch(`http://localhost:8080/webpages?url=${trimHref}`)
    .then(res => res.json())
    .then(link => setLink(link));
  }

  useEffect(() => {
    getUrl()
  }, [hoverHref])



  $(document).ready(function(){

        $(function() {
          var moveLeft = 20;
          var moveDown = 10;
        
          $('a').hover(function(e) {

              $('div#pop-up').show();
              setHoverHref($(this).attr("href"))

          }, function() {

              $('div#pop-up').hide();

          });
          $('a').mousemove(function(e) {
            $("div#pop-up").css('top', e.pageY + moveDown).css('left', e.pageX + moveLeft);
          });
        });
  })
  
  return(
      <>
      <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>

      
          <div id="pop-up">
            <div id="top-bar">
              <img id="hover-logo" src={logo} alt="flickbait-logo" />
              <img id="flickbait-text" src={text} alt="flickbait" />
            </div>
              <p className='baby-boys'>Total votes: {numberOfVotes}</p>
              <p className='baby-boys'>Avg. Rating: {percentageRating}%</p>
              {/* <p>Current Href:{hoverHref}</p> */}
          </div>
    </>
  )
}

export default HoverFunction