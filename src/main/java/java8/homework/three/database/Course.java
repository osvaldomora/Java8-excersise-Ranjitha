package java8.homework.three.database;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
//@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date dateBegin;
	private Date dateEnd;
	private Integer average;

    @ManyToOne(fetch = FetchType.LAZY)  
    private Student student;

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", dateBegin=" + dateBegin + ", dateEnd=" + dateEnd
				+ ", average=" + average + ", student=" + student + "]";
	}



	


}
