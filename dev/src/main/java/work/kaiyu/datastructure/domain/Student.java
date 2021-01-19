package work.kaiyu.datastructure.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {

    private String no;
    private String school;
    private int grade;

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.getClass().getSimpleName() + "--finalize");
        super.finalize();
    }
}
