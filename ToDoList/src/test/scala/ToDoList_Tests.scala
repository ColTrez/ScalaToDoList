package org.ctrezise.todolist

import org.ctrezise.todolist.ToDoList

import org.scalatest.funsuite.AnyFunSuite
import scala.collection.mutable.ArrayBuffer

class ToDoList_Tests extends AnyFunSuite{

  test("can add to todo list") {
    val toDoList = new ToDoList()
    assert(toDoList.tasks.length == 0)
    toDoList.add("something")
    assert(toDoList.tasks.length == 1)
  }

  test("can remove from todo list") {
    val list = new ArrayBuffer[String]().addOne("something")
    val toDoList = new ToDoList(list)
    assert(toDoList.tasks.length == 1)

    toDoList.remove("something")
    assert(toDoList.tasks.length == 0)
  }

  test("can complete task") {
    val list = new ArrayBuffer[String]().addOne("something")
    val toDoList = new ToDoList(list)
    assert(toDoList.tasks.length == 1)
    assert(toDoList.done.length == 0)

    toDoList.completeTask("something")
    assert(toDoList.tasks.length == 0)
    assert(toDoList.done.length == 1)
  }

  test("can delete completed tasks") {
    val list = new ArrayBuffer[String]().addOne("something")
    val toDoList = new ToDoList(list)
    toDoList.completeTask("something")

    toDoList.remove("something")
    assert(toDoList.done.length == 0)
  }
}
