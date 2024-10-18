import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import ClassComponent from './ClassComponent'; // Import the FullStackDevelopment component
import FunctionalComponent from './FunctionalComponent';

ReactDOM.render(
  <React.StrictMode>
    <ClassComponent title="React components"/>
    <FunctionalComponent content= "Hello world" name="John"/>
  </React.StrictMode>,
  document.getElementById('root')

);