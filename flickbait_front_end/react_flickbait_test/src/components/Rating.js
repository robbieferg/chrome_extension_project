
import React from "react";

const Rating = ({selectedWebPage, votes, url}) => {
    
    // const votesLength = votes.filter((vote) => {
    //     return vote.webPage.url === url
    // }
    // );

    const votesLength = votes.length;

    const siteRating = function(){  
        if (votesLength === 0){
            return "No votes"
        } else {
            return (selectedWebPage.upvotes / votesLength) * 100;
        }
    }

    return (
        <>
        <p className="block">Web URL: {selectedWebPage.url}</p>
        <p className="block"> No. of Votes: {votesLength}</p>
        {/* <p className="block">{siteRating}% of Users like this page</p> */}
        </>
    )
}

export default Rating;