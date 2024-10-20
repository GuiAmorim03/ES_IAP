import Head from "next/head";
import Image from "next/image";
import styles from "@/styles/Home.module.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowRight, faCircle, faCheck, faClock, faSpinner } from "@fortawesome/free-solid-svg-icons";
import { apiURL } from "@/components/apiURL";
import { useEffect, useState } from "react";


export default function Home() {

  const userID = 1;
  const [tasks, setTasks] = useState([]);
  const [isModalOpen, setIsModalOpen] = useState(false);

  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [date, setDate] = useState("");
  const [time, setTime] = useState("");
  const [category, setCategory] = useState("");
  const [priority, setPriority] = useState("LOW");

  useEffect(() => {
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

  const openModal = () => {
    setIsModalOpen(true);
  };

  const closeModal = () => {
    setIsModalOpen(false);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (date === "" ) setTime("");
    var fullDate = "";
    if (date !== "" && time !== "") fullDate = date + 'T' + time;
    else if (date !== "" && time === "") fullDate = date ;
    else fullDate = "";

    var task = {
      "title": title,
      "description": description,
      "deadline": fullDate,
      "category": category,
      "priority": priority,
      "personId": userID
    };
    fetch(`${apiURL}/task`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(task)
    })
      .then((response) => response.json())
      .then((data) => {
        setTasks([...tasks, data]);
        setTitle("");
        setDescription("");
        setDate("");
        setTime("");
        setCategory("");
        setPriority("LOW");
      })
      .catch((error) => {
        console.error("Error:", error);
      });
    closeModal();
  };

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
          <div style={{ width: '100%', textAlign: 'right' }}>
            <button className={styles.addTaskButton} onClick={openModal}>+ Add Task</button>
          </div>

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
                  <td>
                    {task.deadline === null ? 'No deadline' :
                      task.deadline.split('T')[0]}
                  </td>
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
        </div>

        {isModalOpen && (
          <div className={styles.modalOverlay} onClick={closeModal}>
            <div className={styles.modalContent} onClick={(e) => e.stopPropagation()}>
              <h2 style={{ marginBottom: '20px' }}>Add New Task</h2>
              <form onSubmit={handleSubmit}>
                <div style={{ fontSize: 'larger', margin: '20px 0 5px 0' }} >Title</div>
                <input
                  style={{ width: '100%', fontSize: 'large' }}
                  type="text"
                  name="title"
                  value={title}
                  onChange={(e) => setTitle(e.target.value)}
                  required
                />
                <div style={{ fontSize: 'larger', margin: '20px 0 5px 0' }} >Description</div>
                <textarea
                  style={{ width: '100%' }}
                  name="description"
                  value={description}
                  onChange={(e) => setDescription(e.target.value)}
                />
                <div style={{ fontSize: 'larger', margin: '20px 0 5px 0' }} >Category</div>
                <input
                  style={{ width: '100%', fontSize: 'large' }}
                  type="text"
                  name="category"
                  value={category}
                  onChange={(e) => setCategory(e.target.value)}
                  required
                />
                <div style={{ fontSize: 'larger', margin: '20px 0 5px 0' }} >Deadline</div>
                <input
                  style={{ width: '40%', fontSize: 'large' }}
                  type="date"
                  name="date"
                  value={date}
                  onChange={(e) => setDate(e.target.value)}
                />
                <input
                  style={{ width: '40%', marginLeft:'20%', fontSize: 'large' }}
                  type="time"
                  name="time"
                  value={time}
                  onChange={(e) => setTime(e.target.value)}
                />
                <div style={{ fontSize: 'larger', margin: '20px 0 5px 0' }} >Priority</div>
                <select
                  name="priority"
                  value={priority}
                  onChange={(e) => setPriority(e.target.value)}
                >
                  <option value="LOW">Low</option>
                  <option value="MEDIUM">Medium</option>
                  <option value="HIGH">High</option>
                </select>
                <br />
                <div style={{ marginTop: '25px', display: 'flex', justifyContent: 'space-between' }}>
                  <button className={styles.addTaskButton} type="submit">Add Task</button>
                  <button className={styles.addTaskButton} type="button" onClick={closeModal}>Cancel</button>
                </div>
              </form>
            </div>
          </div>
        )}
      </main>
    </>
  );
}
