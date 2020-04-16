package main;

import Servlets.SessionsServlet;
import Servlets.UsersServlet;
import account.AccountService;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


import javax.servlet.ServletContext;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();
        accountService.addNewUser("admin");
        accountService.addNewUser("test","test","test@mail.ru");

        System.out.println(accountService.getUserBySessionId("admin"));

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new UsersServlet(accountService)), "/api/v1/users");
        context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/api/v1/sessions");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
