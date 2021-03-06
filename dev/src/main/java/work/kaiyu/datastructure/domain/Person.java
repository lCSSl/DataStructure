package work.kaiyu.datastructure.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.getClass().getSimpleName()+"--finalize");
        super.finalize();
    }
}
