package com.herokuapp.ggrosario.background.tomcat;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@WebListener
public class BackgroundTasksManager implements ServletContextListener{

    private ScheduledExecutorService planificador;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.planificador = Executors.newSingleThreadScheduledExecutor();
        this.planificador.scheduleAtFixedRate(new ReservasChecker(), 0, 1, TimeUnit.DAYS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.planificador.shutdownNow();
    }
    
}
