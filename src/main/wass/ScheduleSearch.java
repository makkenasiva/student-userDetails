package wass;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleSearch {

    @Id
    @JsonProperty("student_id")
    private int studentId;

    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "academic_year")
    private String academicYear;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;
}