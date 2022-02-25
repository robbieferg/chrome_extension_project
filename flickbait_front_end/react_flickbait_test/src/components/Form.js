const Form = ({selectedWebPage, user, url, urlLink}) => {
    return (
        <form>
            <select>
                <option value="upvote" key="up">⬆</option>
                <option value="downvote" key="down">⬇</option>
            </select>
            <input type="text" name="comment" id="comment-box"/>\
            <input type="email" name="email"/>
            <input type="text" name="name"/>
            <input type="text" value={url, urlLink} hidden/>
            <button type="submit">Save</button>
        </form>
    );
}
 
export default Form;