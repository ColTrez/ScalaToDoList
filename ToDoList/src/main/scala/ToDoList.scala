package org.ctrezise.todolist

import scala.collection.mutable.ArrayBuffer

/** Class for tracking tasks. Tasks are either to do or done, and are stored in a collection depending on their status.
 *  Tasks are stored as strings.
 *
 * @param tasks A collection of tasks to initialize the to do list with
 * @param done A collection of completed tasks to initialize the completed task list with
 */
class ToDoList(var tasks: ArrayBuffer[String] = new ArrayBuffer[String](),
               var done: ArrayBuffer[String] = new ArrayBuffer[String]()) {

  /** Adds a task to the collection of tasks to do
   *
   * @param newTask the task to be added to the list
   * @return true if adding a task succeeds, false if it fails
   */
  def add(newTask: String): Boolean = {
    if (tasks.contains(newTask))
      return false
    else if (done.contains(newTask))
      return false
    tasks.append(newTask)
    return true
  }

  /** Removes a task from either the to do list or the completed tasks list depending on whether the task is completed or not
   *
   * @param toDelete the task to be removed
   * @return false to indicate the task did not exist, true to indicate it was sucessfully deleted
   */
  def remove(toDelete: String): Boolean = {
    val inToDo = tasks.contains(toDelete)
    val inCompleted = done.contains(toDelete)
    if (inToDo)
      tasks.remove(tasks.indexOf(toDelete))
    else if (inCompleted)
      done.remove(done.indexOf(toDelete))
    else
      return false

    return true
  }

  /** Moves a task from the to do list to the completed tasks list
   *
   * @param task the task to be marked as complete
   * @return false if the task was not found in the to do list, true if it was successfully moved to complete
   */
  def completeTask(task: String): Boolean = {
    val index = tasks.indexOf(task)
    if (index == -1)
      return false
    done.append(task)
    tasks.remove(index)
    return true
  }
}
