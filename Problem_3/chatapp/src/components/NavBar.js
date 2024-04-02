import React, { useState } from "react";
import GoogleSignin from "../img/btn_google_signin_dark_pressed_web.png";

import { auth } from "../firebase";
import { useAuthState } from "react-firebase-hooks/auth";
import { GoogleAuthProvider, signInWithRedirect } from "firebase/auth";

const NavBar = () => {
  const [user] = useAuthState(auth);
  const googleSignIn = () => {
    const provider = new GoogleAuthProvider();
    signInWithRedirect(auth, provider);
  };
  const signOut = () => {
    auth.signOut();
  };
  return (
    // <nav className="nav-bar">
    //   <h1>ChatBot</h1>
    //   {user ? (
    //     <button onClick={signOut} className="sign-out" type="button">
    //       Sign Out
    //     </button>
    //   ) : (
    //     <button className="sign-in">
    //       <img
    //         onClick={googleSignIn}
    //         src={GoogleSignin}
    //         alt="sign in with google"
    //         type="button"
    //       />
    //     </button>
    //   )}
    // </nav>
    <nav
      style={{
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
        // backgroundColor: "#333",
        color: "white",
        padding: "10px 20px"
      }}
    >
      <h1 style={{ margin: 0 }}>ChatBot</h1>
      {user ? (
        <button
          onClick={signOut}
          style={{
            backgroundColor: "#4CAF50",
            border: "none",
            color: "white",
            padding: "10px 20px",
            textAlign: "center",
            textDecoration: "none",
            display: "inline-block",
            fontSize: "16px",
            cursor: "pointer",
            borderRadius: "5px"
          }}
          type="button"
        >
          Sign Out
        </button>
      ) : (
        <button
          style={{
            backgroundColor: "#4CAF50",
            border: "none",
            color: "white",
            padding: "10px 20px",
            textAlign: "center",
            textDecoration: "none",
            display: "inline-block",
            fontSize: "16px",
            cursor: "pointer",
            borderRadius: "5px"
          }}
          onClick={googleSignIn}
        >
          <img
            src={googleSignIn}
            alt="Sign in with Google"
            style={{ width: "150px", cursor: "pointer" }}
          />
        </button>
      )}
    </nav>
  );
};
export default NavBar;
