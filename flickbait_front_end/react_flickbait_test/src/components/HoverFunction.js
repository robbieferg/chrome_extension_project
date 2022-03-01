import React, { useState, useEffect } from 'react';
import "./HoverFunction.css";
// import Request from "../helpers/request";
import $ from 'jquery';

const HoverFunction = () => {

    const [hoverHref, setHoverHref] = useState("");
    const [hoverLink, setHoverLink] = useState([]);

    const trimHref = hoverHref.replace(/^https?\:\/\//i, "");

    const getUrl = () => {
      fetch(`http://localhost:8080/webpages?url=${hoverHref}`)
      .then(res => res.json())
      .then(link123 => setHoverLink(link123[0]))
    }

    useEffect(() => {
      getUrl()
    }, [hoverHref])

    $(document).ready(function(){
        // $("a").hover(function(){
          // $(this).css("color","pink");
          // $(this).append($(this).attr("href"))
          $(function() {
            var moveLeft = 20;
            var moveDown = 10;
         
            $('a').hover(function(e) {
                // $("div#pop-up").append("<span id='txt_name'><br>" + $(this).attr("href") + "</span>")
                $('div#pop-up').show();
                setHoverHref($(this).attr("href"))

            
              //.css('top', e.pageY + moveDown)
              //.css('left', e.pageX + moveLeft)
              //.appendTo('body');
            }, function() {
                // $("#txt_name").remove()
                $('div#pop-up').hide();
                // $('#txt_name').prepend()
            });
            $('a').mousemove(function(e) {
              $("div#pop-up").css('top', e.pageY + moveDown).css('left', e.pageX + moveLeft);
            });
          });
    })

    let ratingString = hoverLink.averageRating + ""
    console.log(ratingString)
    const stringLength = 5;

    const percentageRating = ratingString.substring(0, stringLength);
    const numberOfVotes = hoverLink.upvotes + hoverLink.downvotes;
    
    return(
        <>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>

       
            {/* <div id="pop-up">
              <img source="react_flickbait_test/public/FlickBait-16.png" alt="FlickBait"/>
              <p>Total votes: {numberOfVotes}</p>
              <br/>
              <p>Average Rating: {percentageRating}</p>
              <p>
                Current Href:{hoverHref}
              </p>
            </div> */}
        
      </>
    )
}

export default HoverFunction