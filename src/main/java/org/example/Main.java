package org.example;

import org.example.entity.Priority;
import org.example.entity.Status;
import org.example.entity.Task;
import org.example.entity.TaskData;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //Ana Set
        Set<Task> annsTasks = new HashSet<>();

        //Anna Set
        Task taskAnn = new Task("workintech", "dummy desc", "ann", Status.IN_QUEUE, Priority.HIGH);
        Task taskAnn2 = new Task("workintech", "dummy desc 2", "ann", Status.IN_QUEUE, Priority.HIGH);
        annsTasks.add(taskAnn);
        annsTasks.add(taskAnn2);

        //Bob Set
        Set<Task> bobsTasks = new HashSet<>();
        Task taskbob = new Task("workintech", "dummy desc 3", "bob", Status.IN_QUEUE, Priority.HIGH);
        Task taskbob2 = new Task("workintech", "dummy desc 5", "bob", Status.IN_QUEUE, Priority.HIGH);
        bobsTasks.add(taskbob);
        bobsTasks.add(taskbob2);

        //Carol Set
        Set<Task> carolsTasks = new HashSet<>();
        Task taskcarol = new Task("workintech", "dummy desc 4", "carol", Status.IN_QUEUE, Priority.HIGH);
        Task taskcarol2 = new Task("workintech", "dummy desc 3", "carol", Status.IN_QUEUE, Priority.HIGH);
        carolsTasks.add(taskcarol);
        carolsTasks.add(taskcarol2);

        //Unassigned Set
        Set<Task> unassignedTasks = new HashSet<>();
        Task unassignedTask = new Task("workintech", "dummy desc 6", null, Status.IN_QUEUE, Priority.HIGH);
        unassignedTasks.add(unassignedTask);

        //Tüm taskları dataya ekleme
        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        //Tüm çalışanlarının üzerindeki tasklar nelerdir ?
        System.out.println("All Tasks : " + taskData.getTasks("all"));

        //Her bir çalışanın üzerindeki tasklar nelerdir ?
        System.out.println("Anns Tasks : " + taskData.getTasks("ann"));
        System.out.println("Bobs Tasks : " + taskData.getTasks("bob"));
        System.out.println("Carols Tasks : " + taskData.getTasks("carol"));

        //Herhangi bir çalışana atanması yapılmamış olan tasklar nelerdir ?
        System.out.println("Unassigned : " + taskData.getDifferences(unassignedTasks, taskData.getTasks("ann")));

        //Birden fazla çalışana atanmış task var mı ? Varsa bunlar hangileri ?
        System.out.println("Anns + Bobs : " + taskData.getIntersection(annsTasks, bobsTasks));
        System.out.println("Bobs + Carols : " + taskData.getIntersection(bobsTasks, carolsTasks));
        System.out.println("Carols + Unassigned : " + taskData.getIntersection(carolsTasks, unassignedTasks));
    }
}