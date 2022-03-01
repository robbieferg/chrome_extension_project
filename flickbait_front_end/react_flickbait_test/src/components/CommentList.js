import React from 'react';
import Comment from './Comment.js';

const CommentList = ({comments}) => {
    if (comments.length === 0) {
        return "No comments yet."
    }

    const commentNodes = comments.map((comment, index) => {
        return (
            <li key={index} className="component-item">
            <div className="component">
            <Comment comment={comment}/>
            </div>
            </li>
        )
    }) 
    return (
        <ul className="component-list">
        {commentNodes}
        </ul>
    )
}

export default CommentList;