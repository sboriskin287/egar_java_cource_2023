package org.example;

import org.example.profile.ProfileDao;
import org.example.profile.dto.TaskDto;
import org.example.profile.entity.Task;
import org.example.profile.entity.TaskDao;

public class Main {
    public static void main(String[] args) {
        var pDao = new ProfileDao();
//        var profileOpt = pDao.findById(5);
//        profileOpt.ifPresent(System.out::println);
//
//        var profiles1 = pDao.findByCriteriaWithQuery(
//                new ProfileCriteria().setFirstNames(List.of("Vodkin", "Denis")));
//        profiles1.forEach(System.out::println);
//        System.out.println();
//
//        var profile2 = pDao.findByCriteriaWithNamedQuery(new ProfileCriteria()
//                .setFirstNames(List.of("Sidr", "Denis")));
//        profile2.forEach(System.out::println);
//        System.out.println();
//
//        var profiles3 = pDao.findByCriteria(new ProfileCriteria()
//                .setLastName("Vodkin"));
//        profiles3.forEach(System.out::println);

//        var shDao = new ShowRoomDao();
//        var shr = shDao.findById(1);
//        System.out.println(shr);
//        System.out.println();

        var p = pDao.findById(1);
        p.ifPresent(System.out::println);

        var tDao = new TaskDao();
        var task = saveTask(tDao);
        updateTask(tDao, task.getId());
    }

    static Task saveTask(TaskDao dao) {
        var taskDto = new TaskDto()
                .setName("Последний день Помпеи")
                .setExecutorId(1);
        return dao.save(taskDto);
    }

    static void updateTask(TaskDao dao, Integer id) {
        var task = dao.findById(id);
        var taskDto = new TaskDto()
                .setName("Первый день Помпеи")
                .setExecutorId(1);
        dao.save(taskDto, task);
    }
}