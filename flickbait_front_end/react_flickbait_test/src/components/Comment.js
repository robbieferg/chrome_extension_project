import React from 'react';
import {Link} from 'react-router-dom';

const Comment = ({comment}) => {
    return (
        <>
        <p>{comment.text}</p>
        <p>{comment.dateAndTime}</p>
        </>
    )
}

export default Comment;