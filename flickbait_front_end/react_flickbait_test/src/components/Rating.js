
import React from "react";

const Rating = ({selectedWebPage}) => {
    

    const rating = function(){  
        if (selectedWebPage.votes.length === 0){
            return "No votes"
        } else {
            return selectedWebPage.upvotes / selectedWebPage.votes.length
        }
    }

    return (
        <>
        <p>{selectedWebPage.url}</p>
        <p>{selectedWebPage.votes.length}</p>
        <p>{rating}</p>
        </>
    )
}

export default Rating;