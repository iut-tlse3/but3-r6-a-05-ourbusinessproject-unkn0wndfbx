package ourbusinessproject;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {
    private InitializationService initializationService;

    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    @PostConstruct
    public void init() {
        try {
            initializationService.initProjects();
        } catch (RuntimeException e) {
        }
    }

    public InitializationService getInitializationService() {
        return initializationService;
    }
}
