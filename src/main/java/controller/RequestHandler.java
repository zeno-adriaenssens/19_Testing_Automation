package controller;

import domain.service.MealsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {

    protected MealsService service = MealsService.getInstance();

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);

    public void setModel (MealsService contactTracingService) {
        this.service = contactTracingService;
    }

    public MealsService getService() {
        return service;
    }

}
