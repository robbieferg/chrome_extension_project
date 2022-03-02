
import React from "react";

const Rating = ({ selectedWebPage, votes, comments, logo }) => {

  // const votesLength = votes.filter((vote) => {
  //     return vote.webPage.url === url
  // }
  // );

  const votesLength = votes.length;

  let commentIndex = 0;

  let commentText = "";

  if (comments.length !== 0) {
    commentIndex = comments.length - 1;
    commentText = comments[commentIndex].text;
  } else {
    commentIndex = 0;
    commentText = "No Comments Listed";
  }

  let ratingString = selectedWebPage.averageRating + ""
  console.log(ratingString)
  const stringLength = 5;

  const percentageRating = ratingString.substring(0, stringLength);



  return (
    <>
      <img id="logo" src={logo} alt="Logo" />
      <p className="block"> No. of Votes: {votesLength}</p>
      <p className="block">{percentageRating}% of Users like this page</p>
      <p className="block">Latest Comment: {commentText}</p>
    </>
  )
}

export default Rating;