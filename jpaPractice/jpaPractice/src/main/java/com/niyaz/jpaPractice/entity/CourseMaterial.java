package com.niyaz.jpaPractice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")//lazy irunthalum enaku couse query fire aguthu
//because to string atha call pannuthu so tostring la thookiren
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name="course_material_sequence",
            sequenceName="course_material_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private  Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,//for simpliicty//error ilama varum course insert panamalae course material insert panalam
            fetch=FetchType.LAZY,
            optional = false//insert agathu course material ilama course varthau invert
//viceversa vaa eluthiten
)
    @JoinColumn(
            name ="course_id",
            referencedColumnName = "courseId"
    )//entha column la join panni match panlam
    private Course course;




}
