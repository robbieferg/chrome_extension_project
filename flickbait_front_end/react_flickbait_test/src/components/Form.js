import { useState } from "react";

const Form = ({ url, urlLink, onWebPageCreate, onUserCreate, onVoteCreate, onCommentCreate }) => {

  const fullUrl = url + urlLink

  const [stateWebPage, setStateWebPage] = useState(
    {
      url: fullUrl
    }
  )

  const [stateUser, setStateUser] = useState(
    {
      name: "",
      email: ""
    }
  )

  const [stateVote, setStateVote] = useState(
    {
      isUpVote: null,
      user: null,
      webPage: null
    }
  )

  const [stateComment, setStateComment] = useState(
    {
      author: null,
      text: "",
      webPage: null
    }
  )

  const handleChange = function (event) {
    let propertyName = event.target.name;
    let copiedUser = { ...stateUser }
    copiedUser[propertyName] = event.target.value;
    setStateUser(copiedUser)
  }

  const handleSubmit = function (event) {
    event.preventDefault();
    onWebPageCreate(stateWebPage);
    onUserCreate(stateUser);
    onCommentCreate(stateComment);
    onVoteCreate(stateVote);
  }

  return (
    <form onSubmit={handleSubmit}>
      <select>
        <option value="upvote" key="up">⬆</option>
        <option value="downvote" key="down">⬇</option>
      </select>
      <input type="text" name="comment" placeholder="type a comment(optional)" id="comment-box" />
      <input type="email" name="email" placeholder="type email" onChange={handleChange} value={stateUser.email}/>
      <input type="text" name="name" placeholder="type name" onChange={handleChange} value={stateUser.name}/>
      <input type="text" value={fullUrl} hidden />
      <button type="submit">Save</button>
    </form>
  );
}

export default Form;