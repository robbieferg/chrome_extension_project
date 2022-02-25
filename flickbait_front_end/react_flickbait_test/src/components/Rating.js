
import React from "react";

const Rating = ({selectedWebPage}) => {
    

    const rating = selectedWebPage.upvotes / selectedWebPage.numberOfVotes;

    return (
        <>
        <p>{selectedWebPage.url}</p>
        <p>{selectedWebPage.upvotes}</p>
        <p>{rating}</p>
        </>
    )
}

export default Rating;