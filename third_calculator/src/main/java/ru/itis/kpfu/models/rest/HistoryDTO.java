package ru.itis.kpfu.models.rest;

import lombok.Data;

import java.util.List;

@Data
public class HistoryDTO {

    private List<Double> history;
}
