import Head from "next/head";
import Image from "next/image";
import styles from "@/styles/Home.module.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowRight, faCircle, faCheck, faClock, faSpinner } from "@fortawesome/free-solid-svg-icons";
import { apiURL } from "@/components/apiURL";
import { useEffect, useState } from "react";


export default function Home() {

  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    const userID = 1;
    const fetchTasks = async () => {
      try {
        const response = await fetch(`${apiURL}/task/${userID}`);
        const data = await response.json();
        setTasks(data);
      } catch (error) {
        console.error("Error fetching tasks: ", error);
      }
    }
    fetchTasks();
  }, []);

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
                <th>Title</th>
                {/* <th>Description</th> */}
                <th>Category</th>
                <th>Deadline</th>
                <th style={{ textAlign: 'center' }}>Priority</th>
                <th style={{ textAlign: 'center' }}>Status</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {tasks.map((task) => (
                <tr key={task.id}>
                  <td>{task.title}</td>
                  {/* <td>{task.description}</td> */}
                  <td>{task.category}</td>
                  <td>{task.deadline.split('T')[0]}</td>
                  <td style={{ textAlign: 'center' }}>
                    <FontAwesomeIcon icon={faCircle} style={{ height: '2rem' }} title={task.priority}
                      {...task.priority === 'LOW' ? { color: 'green' } :
                        task.priority === 'MEDIUM' ? { color: 'orange' } :
                          { color: 'red' }}
                    />
                  </td>
                  <td style={{ textAlign: 'center' }}>
                    <FontAwesomeIcon style={{ height: '2rem' }} title={task.status.replace('_', ' ')}
                      {...task.status === 'PENDING' ? { icon: faClock } :
                        task.status === 'DONE' ? { icon: faCheck } :
                          { icon: faSpinner }}
                    />
                    {/* {task.status} */}
                  </td>
                  <td><FontAwesomeIcon icon={faArrowRight} /></td>
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
