package org.projects.msvc_users.model.exception;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Error {
    private String message;
    private int status;
    private Date date;
}
