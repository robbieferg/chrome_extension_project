
import React from "react";

const Rating = ({selectedWebPage, votes, url}) => {
    
    // const votesLength = votes.filter((vote) => {
    //     return vote.webPage.url === url
    // }
    // );

    const votesLength = votes.length;

    let ratingString = selectedWebPage.averageRating + ""
    console.log(ratingString)
    const stringLength = 5;

    const percentageRating = ratingString.substring(0, stringLength);

    

    return (
        <>
        <p className="block">Web URL: {selectedWebPage.url}</p>
        <p className="block"> No. of Votes: {votesLength}</p>
        <p className="block">{percentageRating}% of Users like this page</p>
        </>
    )
}

export default Rating;