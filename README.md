# TodoMVC Exercise

Sample exercise for the [Effective UI Test Automation With Serenity BDD And Selenium](https://www.udemy.com/course/serenity-bdd-web-testing/?referralCode=3E5878CF6F4676EF507B) course on Udemy.

In this exercise, you will complete a series of simple tests against the [TodoMVC](https://todomvc.com/examples/angularjs/#/) application using core Serenity BDD features.

You can see a [sample solution here](https://github.com/serenity-dojo/serenity-web-training/tree/todomvc-solution).

## Get the code

Git:

    git clone https://github.com/serenity-dojo/serenity-web-training/tree/todomvc-start
    cd serenity-junit-starter
    git checkout todomvc-start
    git checkout -b my-todomvc-exercise

You will find the tests to implement in the `WhenAddingTasks` and `WhenCompletingATask` classes.

## Exercise 1

Open the `WhenAddingTasks` and implement the `addingASingleTask()` method. Use a Serenity action class to implement the steps. Make sure the steps and assertions appear in the reports.

## Exercise 2

Open the `WhenAddingTasks` and implement the `addingMultipleTasks()` method. You can reuse methods developed in the previous exercise.

## Exercise 3

Open the `WhenCompletingATask` class and implement the `activeTasksShouldNotShowCompletedTasks()` method.

## Exercise 4

Open the `WhenCompletingATask` class and implement the `completedTasksShouldNotShowActiveTasks()` method.

## Exercise 5 ()

Open the `WhenDeletingATask` class and implement the `deletedItemsShouldDissapearFromTheList()` method.