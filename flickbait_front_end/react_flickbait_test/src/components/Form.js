import { useState } from "react";

const Form = ({selectedWebPage, user, url, urlLink}) => {

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

const [stateComment, setStateComment] = useState(
    {
        author: null,
        text: "",
        webPage: null
    }
)

const [stateVote, setStateVote] = useState(
    {
        isUpVote: false,
        user: null,
        webPage: null
    }
)

const handleChange = function(event){
    let propertyName = event.target.name;
    let copiedUser = {...stateUser}
    copiedUser[propertyName] = event.target.value;
    setStateUser(copiedUser)
}

    return (
        <form>
            <select>
                <option value="upvote" key="up">⬆</option>
                <option value="downvote" key="down">⬇</option>
            </select>
            <input type="text" name="comment" id="comment-box"/>\
            <input type="email" name="email" onChange={handleChange}/>
            <input type="text" name="name" onChange={handleChange}/>
            <input type="text" value={url, urlLink} hidden/>
            <button type="submit">Save</button>
        </form>
    );
}
 
export default Form;