import { useState } from "react";

const Form = ({ url, urlLink, handleFullPost }) => {

  const [fullUrl, _] = useState(url + urlLink)

  const [comment, updateComment] = useState("")

  const onVote = (isUpVote) => {
    handleFullPost(fullUrl, isUpVote, comment)
  }

  return (

    <div>
      <button onClick={() => onVote(true)} value="upvote" key="up">⬆</button>
      <button onClick={() => onVote(false)} value="downvote" key="down">⬇</button>
      <input type="text" name="comment" placeholder="Your comment" 
      value={comment} onChange={(e) => updateComment(e.target.value)} />
      <input type="text" placeholder={fullUrl} readOnly />
    </div>
    
  );
}

export default Form;