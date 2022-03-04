package java8.homework.three.database;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
//@ToString
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	

/*	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="StudentCourse",
			   joinColumns = @JoinColumn(name="idStudent"),
			   inverseJoinColumns = @JoinColumn(name="idCourse")			
			)*/
/*    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch=FetchType.EAGER)
    @JoinColumn(name = "student_id")//it is de foreig key of post_comment */
	
    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
            ,fetch=FetchType.EAGER
        )
    private List<Course> courses;

	public void add(Course student) {
		if (courses == null) {
			courses = new LinkedList<Course>();
		}
		courses.add(student);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name  + "]";
	}
	
	
}
