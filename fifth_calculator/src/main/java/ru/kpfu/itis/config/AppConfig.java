package ru.kpfu.itis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.kpfu.itis.beans.components")
@ComponentScan("ru.kpfu.itis.beans.controllers")
public class AppConfig {}
