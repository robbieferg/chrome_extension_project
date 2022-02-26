import { useState } from "react";

const Form = ({ url, urlLink, onWebPageCreate, onVoteCreate, onCommentCreate }) => {

  const fullUrl = url + urlLink

  const [stateWebPage, setStateWebPage] = useState(
    {
      url: fullUrl
    }
  )


  const [stateVote, setStateVote] = useState(
    {
      isUpVote: false,
      webPage: stateWebPage
    }
  )

  const [stateComment, setStateComment] = useState(
    {
      author: "",
      text: "",
      webPage: stateWebPage
    }
  )

 

  const handleVoteChange = function(event) {
      const vote = event.target.value;
      let copiedVote = { ...stateVote }
      let isUpVote = true;
      
      if(vote == "upvote") {
          copiedVote[isUpVote] = true;
      }
      else {
          copiedVote[isUpVote] = false;
      }
      setStateVote(copiedVote);
  }

  const handleCommentChange = function(event) {
      const text = event.target.value;
      let copiedComment = { ...stateComment }
      copiedComment[text] = text;
  }

  const handleSubmit = function (event) {
    event.preventDefault();
    onWebPageCreate(stateWebPage);
    // onUserCreate(stateUser);
    // onCommentCreate(stateComment);
    // onVoteCreate(stateVote);
  }

  return (
    <form onSubmit={handleSubmit}>
      <select onChange={handleVoteChange}>
        <option value="upvote" key="up">⬆</option>
        <option value="downvote" key="down">⬇</option>
      </select>
      <input type="text" name="name" placeholder="type name"/>
      <input type="text" value={fullUrl} hidden />
      <button type="submit">Save</button>
    </form>
  );
}

export default Form;