
import React from "react";

const Rating = ({selectedWebPage}) => {
    

    const rating = selectedWebPage.upvotes / selectedWebPage.numberOfVotes;

    return (
        <>
        <p>{selectedWebPage.url}</p>
        <p>{rating}</p>
        {/* <p>{url}</p> */}
        </>
    )
}

export default Rating;