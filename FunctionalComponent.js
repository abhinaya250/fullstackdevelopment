import React,{useState} from 'react';

function FunctionalComponent(props) {
    const [message,setMessage]=useState("This is FSD lab.");
    const change=()=>{
        setMessage("message changed");
    };
    
  return (
    <div>
    <h3>{props.content}</h3>
      <p>Name: {props.name}</p> {/* Accessing the name prop */}
      <p>{message}</p>
     <button onClick={change}>change</button>
    </div>
  );
}

export default FunctionalComponent;
