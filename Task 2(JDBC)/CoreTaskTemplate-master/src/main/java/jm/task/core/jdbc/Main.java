package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        User[] users = { new User("Silicia","Stone", (byte) 10),
                new User("Jefry","Bennet", (byte) 20),
                new User("Semen","Nicolaevich", (byte) 30),
                new User("Azer","Nique", (byte) 40) };

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        for (User user : users ) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println(user.getName() + " добавлен в базу данных");
        }
        
        System.out.println();
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
