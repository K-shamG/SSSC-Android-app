package ghelani.kshamina.sssc_android_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.UUID;

import ghelani.kshamina.sssc_android_app.model.Course;

@Entity(tableName = "courses",
        foreignKeys = @ForeignKey(
                entity = TermEntity.class,
                parentColumns = "term_id",
                childColumns = "course_term_id",
                onDelete = ForeignKey.CASCADE
        ))
public class CourseEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "course_id")
    public String courseId;  //primary key
    @ColumnInfo(name = "course_name")
    public String courseName;
    @ColumnInfo(name = "course_code")
    public String courseCode;
    @ColumnInfo(name = "course_credits")
    public double courseCredits;
    @ColumnInfo(name = "course_is_major_course")
    public boolean courseIsMajorCourse;
    @ColumnInfo(name = "course_final_grade")
    public String courseFinalGrade;
    @ColumnInfo(name = "course_term_id")
    public String courseTermId;  //foreign key refer to Term:term_id;

    public CourseEntity() {
    }

    public CourseEntity(String name, String code, double credits, boolean isMajorCourse, String finalGrade, String termId) {
        courseId = UUID.randomUUID().toString();
        this.courseName = name;
        this.courseCode = code;
        this.courseCredits = credits;
        this.courseIsMajorCourse = isMajorCourse;
        this.courseFinalGrade = finalGrade;
        this.courseTermId = termId;
    }

    public CourseEntity(Course course) {
        courseId = UUID.randomUUID().toString();
        this.courseName = course.getCourseName();
        this.courseCode = course.getCourseCode();
        this.courseCredits = course.getCourseCredits();
        this.courseIsMajorCourse = course.isCourseIsMajorCourse();
        this.courseFinalGrade = course.getCourseFinalGrade();
        this.courseTermId = course.getCourseTermId();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        CourseEntity courseEntity = (CourseEntity) obj;
        return courseId.equals(courseEntity.courseId);
    }

    @Override
    public int hashCode() {
        return 31 + courseId.hashCode();
    }
}
