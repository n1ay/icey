package com.github.n1ay.icey.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class ErrorControllerImpl implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        String viewName = "error";
        Optional<Object> maybeStatus = Optional.ofNullable(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        if (maybeStatus.isPresent()) {
            int rc = Integer.parseInt(maybeStatus.get().toString());
            viewName = getViewName(rc);
        }
        return "error/" + viewName;
    }

    public String getViewName(int rc) {
        switch (rc) {
            case 404:
                return "error-404";
            case 500:
                return "error-500";
            default:
                return "error";
        }
    }
}
