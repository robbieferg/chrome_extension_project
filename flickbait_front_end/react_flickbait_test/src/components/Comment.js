import React from 'react';
import {Link} from 'react-router-dom';

const Comment = ({comment}) => {
    return (
        <>
        <p>Comment: {comment.text}</p>
        </>
    )
}

export default Comment;