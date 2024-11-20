import React from "react";
import styles from "@/styles/Login.module.css";

export default function Login() {
  const handleLogin = () => {
    window.location.href = "http://localhost:8080/oauth2/authorization/cognito";
  };

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Welcome to the To Do List Manager!</h1>
      <p className={styles.description}>
        Here you can manage your tasks efficiently and stay organized.
      </p>
      <button className={styles.loginButton} onClick={handleLogin}>
        Login
      </button>
    </div>
  );
}
