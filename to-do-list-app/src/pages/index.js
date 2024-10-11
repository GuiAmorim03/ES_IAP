import Head from "next/head";
import Image from "next/image";
import styles from "@/styles/Home.module.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowRight } from "@fortawesome/free-solid-svg-icons";


export default function Home() {
  // Define your tasks data
  const tasks = [
    {
      id: 1,
      title: "Setup Frontend",
      description: "Create the frontend using React",
      status: "Completed",
    },
    {
      id: 2,
      title: "Set Up Backend",
      description: "Create the backend using Spring Boot",
      status: "In Progress",
    },
    {
      id: 3,
      title: "Set Up Database",
      description: "Initialize the PostgreSQL database and set up schemas.",
      status: "Pending",
    },
  ];

  return (
    <>
      <Head>
        <title>Task Manager</title>
        <meta name="description" content="A simple task management app" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <main className={styles.page}>
        <div className={styles.box}>
          <h1 className={styles.title}>To Do</h1>
          
          {/* Task Table */}
          <table className={styles.taskTable}>
            <thead>
              <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Status</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {tasks.map((task) => (
                <tr key={task.id}>
                  <td>{task.id}</td>
                  <td>{task.title}</td>
                  <td>{task.description}</td>
                  <td>{task.status}</td>
                  <td><FontAwesomeIcon icon={faArrowRight} className="arrow"/></td>
                </tr>
              ))}
            </tbody>
          </table>
          
          {/* Optionally, you can remove or keep the existing CTAs and footer */}
        </div> 
      </main>
    </>
  );
}
