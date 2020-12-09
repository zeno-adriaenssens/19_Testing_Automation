package controller;

import domain.service.MealsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Overview extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String ja = request.getParameter("leeg");
        if (ja == null) {
            request.setAttribute("meals", MealsService.getInstance().sortMeals());

        }
        return "meals.jsp";
    }
}
