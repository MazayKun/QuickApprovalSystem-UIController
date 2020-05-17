package qas.uicontroller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Process {

    private Integer id_process;
    private Integer process_type_id;
    private String name;
    private String description;
    private Integer user_start_id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Timestamp date_start;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Timestamp date_end_planning;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Timestamp date_end_fact;
    private Integer status_id;

    private String temp_date_end_planning;
}
