public class GradeBookTest {
    public  static void main(String[] args){
        final int NUMBER_OF_STUDENT = 3;
        Student[] students = new Student[NUMBER_OF_STUDENT];
        students[0] = new Student("A112223058","許志");
        students[1] = new Student("A112222014","林志");
        students[2] = new Student("A112223100","賴志");
        GradeBook gradeBook = new GradeBook("Java程式設計",students,NUMBER_OF_STUDENT);
        gradeBook.processStudentsGrades();;
        gradeBook.displayGradeReport();
    }
}
