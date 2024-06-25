package kz.nurgissa.entities;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private Integer id;
    private String phoneNumber;
    private String name;

    public Contact(String phoneNumber, String name){
        this.phoneNumber = phoneNumber;
        this.name = name;
    }
}
