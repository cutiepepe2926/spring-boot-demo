package com.example.basic.chap06;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleVO {
    private int num;
    private String first;
    private String last;
    private LocalDateTime regdate;
}
