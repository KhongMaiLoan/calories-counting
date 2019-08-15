package com.teamnaughty.food.myspringcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    private String password;

    @Column(name = "sumcalo")
    private Double sumcalo;

    @Column(name = "atefood")
    public String atefood;

    @Column(name = "selectfood")
    public String selectfood;

    @Column(name = "familyname")
    public String familyname;

    @Column(name = "weight")
    public String weight;

    @Column(name = "height")
    public String height;

    @Column(name = "gender")
    public String gender;

    @Column(name = "age")
    public String age;

    @Column(name = "trainingintensity")
    public String trainingintensity;


    @Column(name = "sumdam")
     private Double sumdam;

    @Column(name = "sumbeo")
    private Double sumbeo;

    @Column(name = "sumbotduong")
    private Double sumbotduong;

      @Column(name = "sumxo")
    private Double sumxo;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User() {
        name = "";
        email = "";
        password = "password";
        sumcalo = new Double(0);
        atefood = "";
        selectfood = "";
        familyname = "";
        lastName = "";
        active=1;
        weight = "Cân nặng (kg)";
        height = "Chiều cao (cm)";
        gender = "nam";
        age = "Tuổi";
        trainingintensity = "Khong tap the duc gi ca";
        sumdam =  new Double(0);
        sumbeo =  new Double(0);
        sumbotduong =  new Double(0);
        sumxo =  new Double(0);
    }

    public User(String name, String email, String password, Double sumcalo,
                String atefood, String selectfood, String familyname, String weight,
                String height, String gender, String age, String trainingintensity,
                Double sumdam, Double sumbeo, Double sumbotduong, Double sumxo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.sumcalo = sumcalo;
        this.atefood = atefood;
        this.selectfood = selectfood;
        this.familyname = familyname;
        this.weight =weight;
        this.height  = height;
        this.gender = gender;
        this.age = age;
        this.trainingintensity = trainingintensity;
        this.sumdam = sumdam;
         this.sumbeo = sumbeo;
         this.sumbotduong = sumbotduong;
        this.sumxo = sumxo;
        this.lastName="";
        this.active=1;
    }


    public void refreshFood(){
        atefood = "";
        sumcalo = new Double(0);
        sumdam =  new Double(0);
        sumbeo =  new Double(0);
        sumbotduong =  new Double(0);
        sumxo =  new Double(0);
    }


    public boolean is_infor_completed(){
        return !(age.equals("Tuổi"));
    }

    public List<String > getFoodlist(){
        String[] foods = atefood.split("\\.");
        List<String> list_ = Arrays.asList(foods);

        list_.replaceAll(String::trim);

        List<String> last_list = new ArrayList<String>(list_);
        last_list.removeAll(Arrays.asList("", null));

        for (int i=0; i< last_list.size(); i++ ) {
            if (last_list.get(i).equals(":")){
                last_list.remove(i);
                i--;
            }
        }

        return last_list;
    }

    public double getThred(){
        return 1200;
    }

    public boolean checkthredhold(){
        if (sumcalo <= getBMR())
            return true;
        else
            return false;
    }
    public double sumcalo_divide_bmr(){
        return sumcalo/getBMR()*100;
    }

    public double getBMR(){
        double bmr = 0;
        if (gender.equals("nam")){
             bmr = 9.247*Double.parseDouble(weight ) + 3.098*Double.parseDouble(height) - 4.33*Double.parseDouble(age) + 447.6;
        }
        else {
            bmr = 13.397*Double.parseDouble(weight) + 4.799*Double.parseDouble(height )- 5.677*Double.parseDouble(age )+ 88.362;
        }
        switch (trainingintensity){
            case "Ít vận động hoặc không tập thể dục":
                bmr = bmr*1.2;
                break;
            case "Tập thể dục 1-3 lần/tuần":
                bmr = bmr*1.375;
                break;
            case "Tập thể dục 3-5 lần/tuần":
                bmr = bmr*1.55;
                break;
            case "Tập thể dục 6-7 lần/tuần":
                bmr = bmr*1.725;
                break;
            case "Tập thể dục cường độ cao hơn 7 lần/tuần":
                bmr = bmr*1.9;
                break;
            default:
        };
        return Math.round(bmr);
    }

    public String getSelectfood() {
        return selectfood;
    }

    public void setSelectfood(String selectfood) {
        this.selectfood = selectfood;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSumcalo() {
        return sumcalo;
    }

    public void setSumcalo(Double sumcalo) {
        this.sumcalo = sumcalo;
    }

    public void setSumcalo(double s){
        this.sumcalo = new Double(s);
    }
    public void setSumcalo(String s)
    {
        this.sumcalo = new Double(Double.parseDouble(s));
    }

    public void addSumcalo(Double s){
        sumcalo = sumcalo + s;
    }
    public void addSumdam(Double s){
        sumdam = sumdam + s;
    }
    public void addSumbotduong(Double s){
        sumbotduong = sumbotduong + s;
    }
    public void addSumbeo(Double s){
        sumbeo = sumbeo + s;
    }
    public void addSumxo(Double s){
        sumxo = sumxo + s;
    }

    public String getAtefood() {
        return atefood;
    }

    public void setAtefood(String atefood) {
        this.atefood = atefood;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTrainingintensity() {
        return trainingintensity;
    }

    public void setTrainingintensity(String trainingintensity) {
        this.trainingintensity = trainingintensity;
    }

    public Double getSumdam() {
        return sumdam;
    }

    public void setSumdam(Double sumdam) {
        this.sumdam = sumdam;
    }

    public Double getSumbeo() {
        return sumbeo;
    }

    public void setSumbeo(Double sumbeo) {
        this.sumbeo = sumbeo;
    }

    public Double getSumbotduong() {
        return sumbotduong;
    }

    public void setSumbotduong(Double sumbotduong) {
        this.sumbotduong = sumbotduong;
    }

    public Double getSumxo() {
        return sumxo;
    }

    public void setSumxo(Double sumxo) {
        this.sumxo = sumxo;
    }
}