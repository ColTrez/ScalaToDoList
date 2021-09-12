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

  test("handles attempts to remove nonexistant") {
    val list = new ArrayBuffer[String]().addOne("nothing")
    val toDoList = new ToDoList(list)

    assert(!toDoList.remove("something"))
  }

  test("handles attempts to complete nonexistant tasks") {
    val list = new ArrayBuffer[String]().addOne("nothing")
    val toDoList = new ToDoList(list)

    assert(!toDoList.completeTask("something"))
  }

  test("user cannot add duplicate tasks") {
    val dupe = "something"
    val list = new ArrayBuffer[String]().addOne(dupe)
    val toDoList = new ToDoList(list)
    toDoList.add(dupe)

    assert(toDoList.tasks.length == 1)
  }

  test("user cannot add completed task") {
    val dupe = "something"
    val list = new ArrayBuffer[String]().addOne("something")
    val toDoList = new ToDoList(done = list)

    assert(!toDoList.add("something"))
  }
}
