package me.ewan.springrestapi.evetns;

import lombok.*;
import me.ewan.springrestapi.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
@Entity
public class Event {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location; // (optional) If it is not exists, being online meeting
    private int basePrice; // (optional)
    private int maxPrice; // (optional)
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus = EventStatus.DRAFT;

    @ManyToOne
    private Account manager;

    public void update(){

        //update free
        if(this.basePrice == 0 && this.maxPrice == 0){
            this.free = true;
        }else {
            this.free = false;
        }

        //update location
        if(this.location == null || this.location == ""){
            offline = false;
        }else {
            offline = true;
        }
    }
}