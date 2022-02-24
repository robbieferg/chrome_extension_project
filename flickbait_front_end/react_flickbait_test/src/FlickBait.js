import React, { useState, useEffect } from "react";
import "./App.css";

import styled from "styled-components";

const Container = styled.div`
    z-index:2;
    border: 1px solid grey;
    position: absolute;
    background: white;
    top: ${(props) => props.y + "px"};
    left: ${(props) => props.x + "px"};    
`;

const Header = styled.div`
    height:20px;
    background-color:papayawhip;
`;

const StyledButton = styled.button`
    height: 20px;
    border: none;
    opacity: 0.5;
    float: right;
`;


const StyledTextArea = styled.textarea`
    color:dark grey;
    height: 200px;
    width: 200px;
    border: none;
    background-color: hsla(0 ,0%,100%,0.2);
`;

const FlickBait = () => {
    const [notes, setNotes] = useState([]);
    const url = window.location.href;

    // listen for shift + click to add note
    useEffect(() => {
        function clickListener(e) {
            if (e.shiftKey) {
                setNotes((prevNotes) => [...prevNotes, { x: e.pageX, y: e.pageY }]);
            }
        }
        document.addEventListener("click", clickListener);
        return () => document.removeEventListener("click", clickListener);
    }, []);

        

    return (
        <div>
            
            {notes.map((note) => {
                const handleChange = (e) => {
                    const editedText = e.target.value;
                    setNotes((prevNotes) =>
                        prevNotes.reduce(
                            (acc, cv) =>
                                cv.x === note.x && cv.y === note.y
                                    ? acc.push({ ...cv, note: editedText }) && acc
                                    : acc.push(cv) && acc,
                            []
                        )
                    );
                };

                const handleDelete = () => {
                    setNotes((prevNotes) =>
                        prevNotes.reduce(
                            (acc, cv) =>
                                cv.x === note.x && cv.y === note.y ? acc : acc.push(cv) && acc,
                            []
                        )
                    );
                };
                return (
                    <Container x={note.x} y={note.y} className="react-sticky-note">
                        <Header>
                            <StyledButton onClick={handleDelete}>X</StyledButton>
                        </Header>
                        <StyledTextArea
                            onChange={handleChange}
                            value={note.note ? note.note : ""}
                        />
                    </Container>
                );
            })}
        </div>
    );
};

export default FlickBait;
