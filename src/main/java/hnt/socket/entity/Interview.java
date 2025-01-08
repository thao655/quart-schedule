package hnt.socket.entity;

import hnt.socket.common.InterviewStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate interviewDate;
    private LocalTime fromTime;
    private LocalTime toTime;
    private String meetingId;
    private String location;

    @ManyToOne
    private Candidate candidate;

    @ManyToMany
    @JoinTable(name = "interview_interviewers",
            joinColumns = @JoinColumn(name = "interview_id"),
            inverseJoinColumns = @JoinColumn(name = "interviewers_id"))
    private Set<User> interviewers = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private InterviewStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Job job;
}
