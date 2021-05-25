package pl.soa.lab;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;



public class Student {

    private String firstName;
    private String surname;
    private String indexNumber;
    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
        private List courses = new ArrayList<>();


    public Student(String firstName, String surname, String index, List<String> courses) {
        this.firstName = firstName;
        this.surname = surname;
        this.indexNumber = index;
        this.courses = courses;
    }

    public Student(){
        this.firstName = "";
        this.surname = "";
        this.indexNumber = "";
        this.courses = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getIndexNumber() {
        return indexNumber;
    }


    public List getCourses() {
        return courses;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setSurname(String name) {
        this.surname = name;
    }

    public void setIndexNumber(String name) {
        this.indexNumber = name;
    }

    public void setCourses(String val) {
        if(courses==null){
            courses = new ArrayList<String>();
        }
        courses.add(val);
    }
}

