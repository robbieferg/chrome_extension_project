import { useState } from "react";

const VoteForm = ({url, urlLink, onWebPageCreate, onUserCreate, onVoteCreate, onCommentCreate}) => {

const [stateWebPage, setStateWebPage] = useState(
    {
        url: {url} + {urlLink}
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

const handleChange = function(event){
    let propertyName = event.target.name;
    let copiedUser = {...stateUser}
    copiedUser[propertyName] = event.target.value;
    setStateUser(copiedUser)
}

const handleSubmit = function(event){
    event.preventDefault();
    if (stateWebPage.id){
        onUpdate(stateWebPage)
    } else {
        onCreate(stateWebPage);
    }
}

    return (
        <form onSubmit={handleSubmit}>
            <select>
                <option value="upvote" key="up">⬆</option>
                <option value="downvote" key="down">⬇</option>
            </select>
            <button type="submit">Save</button>
        </form>


    );
}
 
export default VoteForm;