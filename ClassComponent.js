import React from 'react';
import fsdimage from './img.jpg';

// FullStackDevelopment class component
class ClassComponent extends React.Component {
    constructor(props){
        super(props);
        this.state={
            message : "React, the popular JavaScript library, offers several exciting reasons for developers to learn it."
        };
    };
    changeMessage=()=>{
        this.setState({message:"message changed!"})
    }




  render() {
    return (
      <div style={{ textAlign: 'center', padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        {/* Title */}
        <h1>{this.props.title}</h1>

        {/* Image */}
        <img 
          src={fsdimage} // Adjust this path to the location of your image
          alt="Technology"
          style={{ width: '300px', height: 'auto', margin: '20px 0' }}
        />

        {/* Content */}
        <p>
            {this.state.message};
        </p>
        <button onClick={this.changeMessage}>Change Message</button>
      </div>
    );
  }
}
export default ClassComponent;