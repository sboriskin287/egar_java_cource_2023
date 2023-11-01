package org.example.profile.entity;

import org.example.profile.dto.TaskDto;
import org.example.util.EMFSingleton;

import javax.persistence.EntityManagerFactory;

public class TaskDao {
    private final EntityManagerFactory emf;

    public TaskDao() {
        emf = EMFSingleton.getEmf();
    }

    public Task findById(Integer id) {
        var em = emf.createEntityManager();
        return em.find(Task.class, id);
    }

    public Task save(TaskDto taskDto) {
        String s1 = "string";
        var em = emf.createEntityManager();
        var pv = em.find(Profile.class, taskDto.getExecutorId());
        var task = new Task()
                .setName(taskDto.getName())
                .setExecutor(pv);
        em.persist(task);
        em.flush();
        em.close();
        return task;
    }

    public void save(TaskDto taskDto, Task task) {
        var em = emf.createEntityManager();
        var pv = em.find(Profile.class, taskDto.getExecutorId());
        task
                .setName(taskDto.getName())
                .setExecutor(pv);
        em.merge(task);
        em.flush();
        em.close();
    }
}
