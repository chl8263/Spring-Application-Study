package com.example.springmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = {EventController.class, EventApi.class})
public class BaseController {
}
