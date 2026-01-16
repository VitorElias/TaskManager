package com.TaskManager.TaskManager.Exceptions;

import java.time.LocalDateTime;

public record CustomResponseEntity(LocalDateTime timeStamp, String message, String details) {}
