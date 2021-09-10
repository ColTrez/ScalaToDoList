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
   * @return
   */
  def add(newTask: String) = {
    tasks.append(newTask)
  }

  /** Removes a task from either the to do list or the completed tasks list depending on whether the task is completed or not
   *
   * @param toDelete the task to be removed
   * @return
   */
  def remove(toDelete: String) = {
    var index = tasks.indexOf(toDelete)
    if (index == -1) { //task was not in tasks, should be in done
      index = done.indexOf(toDelete)
      done.remove(index)
    }
    else {
      tasks.remove(index)
    }
  }

  /** Moves a task from the to do list to the completed tasks list
   *
   * @param task the task to be marked as complete
   * @return
   */
  def completeTask(task: String) = {
    val index = tasks.indexOf(task)
    done.append(task)
    tasks.remove(index)
  }
}
