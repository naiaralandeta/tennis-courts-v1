
package com.tenniscourts.guests;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class GuestDTO {
    private Long id;
    private String name;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
    private String ipNumberCreate;
    private String ipNumberUpdate;
    private Long userCreate;
    private Long userUpdate;
    
}
