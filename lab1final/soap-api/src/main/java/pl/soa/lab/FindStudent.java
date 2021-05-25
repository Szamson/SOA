package pl.soa.lab;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateless
@WebService
public class FindStudent {

    List<Student> students = new ArrayList<Student>();

    @WebMethod(action = "find")
    @WebResult(name = "getStudent")
    public List<Student> find(@WebParam(name = "indexno")String no){

        Student JanKowalski = new Student("Jan", "Kowalski", "111111",Arrays.asList("SOA","POC"));
        Student AsiaNowak = new Student("Asia", "Nowak", "222222",  Arrays.asList ("SOA","TO"));
        if(students.isEmpty()){
            this.students.add(AsiaNowak);
            this.students.add(JanKowalski);
        }


        if(no.equals("all")){
            return students;
        }else{
            for(Student student : this.students){
                if(student.getIndexNumber().equals(no)){
                    return Arrays.asList(student);
                }
            }
            return null;
        }
    }

    @WebMethod
    public void addStudents(@WebParam( name = "firstname") String firstName,
                            @WebParam( name = "surname") String surname,
                            @WebParam( name = "index") String index,
                            @WebParam( name = "course") String course){

        boolean found = false;

        for(Student student : this.students){
            if (student.getIndexNumber().equals(index)) {
                found = true;
                break;
            }
        }
        if(found){
            this.editStudent(firstName,surname,index,course);
        }else{

            Student newStudent = new Student();

            newStudent.setFirstName(firstName);
            newStudent.setSurname(surname);
            newStudent.setIndexNumber(index);
            newStudent.setCourses(course);


            students.add(newStudent);
        }
    }

    @WebMethod
    public void editStudent(@WebParam( name = "firstname") String firstName,
                            @WebParam( name = "surname") String surname,
                            @WebParam( name = "index") String index,
                            @WebParam( name = "course") String course){

        boolean found = false;
        Student editStudent = null;

        for(Student student : this.students){
            if(student.getIndexNumber().equals(index)){
                editStudent = student;
                found = true;
            }
        }
        if(!found){
            this.addStudents(firstName,surname,index,course);
        }else{
            editStudent.setFirstName(firstName);
            editStudent.setSurname(surname);
            editStudent.setIndexNumber(index);
            editStudent.setCourses(course);
        }
    }
}

